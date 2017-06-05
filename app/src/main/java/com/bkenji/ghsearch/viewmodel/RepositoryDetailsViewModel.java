package com.bkenji.ghsearch.viewmodel;

import com.bkenji.ghsearch.databinding.ActivityRepositoryDetailsBinding;
import com.bkenji.ghsearch.model.User;
import com.bkenji.ghsearch.requests.GitHubProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bruno Tiba on 04/06/2017.
 */

public class RepositoryDetailsViewModel {

    private ActivityRepositoryDetailsBinding mBinding;
    private UserListAdapter mAdapter;

    public RepositoryDetailsViewModel(ActivityRepositoryDetailsBinding binding,
                                      UserListAdapter adapter) {
        mBinding = binding;
        mAdapter = adapter;
        mBinding.setLoading(true);

        GitHubProvider.getGithubService()
                .getContributors(mBinding.getRepository().owner.name, mBinding.getRepository().name)
                .enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mBinding.setLoading(false);
                if (response.isSuccessful()) {
                    mAdapter.updateData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mBinding.setLoading(false);
            }
        });
    }

    public void onDestroy() {
        mAdapter.onDestroy();
    }
}
