package com.bkenji.ghsearch.viewmodel;

import android.support.v7.widget.SearchView;

import com.bkenji.ghsearch.databinding.ActivityUserSearchBinding;
import com.bkenji.ghsearch.model.UserSearch;
import com.bkenji.ghsearch.requests.GitHubProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bruno Tiba on 04/06/2017.
 */

public class UserSearchViewModel implements SearchView.OnQueryTextListener{

    private UserListAdapter mAdapter;
    private ActivityUserSearchBinding mBinding;

    public UserSearchViewModel(ActivityUserSearchBinding binding,
                               UserListAdapter adapter) {
        mBinding = binding;
        mAdapter = adapter;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mBinding.setLoading(true);
        GitHubProvider.getGithubService()
                .searchUsers(query.trim())
                .enqueue(new Callback<UserSearch>() {
                    @Override
                    public void onResponse(Call<UserSearch> call,
                                           Response<UserSearch> response) {
                        mBinding.setLoading(false);
                        if(response.isSuccessful()) {
                            mAdapter.updateData(response.body().users);
                            mBinding.setEmptyData(mAdapter.getItemCount() == 0);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserSearch> call, Throwable t) {
                        mBinding.setLoading(false);
                    }
                });
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
