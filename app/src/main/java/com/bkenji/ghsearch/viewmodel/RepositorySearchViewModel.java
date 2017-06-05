package com.bkenji.ghsearch.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.SearchView;

import com.bkenji.ghsearch.databinding.ActivityRepositorySearchBinding;
import com.bkenji.ghsearch.model.Repository;
import com.bkenji.ghsearch.model.RepositorySearch;
import com.bkenji.ghsearch.requests.GitHubProvider;
import com.bkenji.ghsearch.view.RepositoryDetailsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bruno Tiba on 04/06/2017.
 */

public class RepositorySearchViewModel implements SearchView.OnQueryTextListener,
        RepositorySearchListAdapter.OnRepositorySelectedListener{

    private Activity mContext;
    private ActivityRepositorySearchBinding mBinding;
    private RepositorySearchListAdapter mAdapter;

    public RepositorySearchViewModel(Activity context,
                                     ActivityRepositorySearchBinding binding,
                                     RepositorySearchListAdapter adapter) {
        mContext = context;
        mBinding = binding;
        mBinding.setEmptyData(true);
        mAdapter = adapter;
        mAdapter.setListener(this);
    }

    public void onDestroy() {
        mContext = null;
        mAdapter.onDestroy();
        mAdapter = null;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mBinding.setLoading(true);
        GitHubProvider.getGithubService()
                .searchRepositories(query.trim())
                .enqueue(new Callback<RepositorySearch>() {
            @Override
            public void onResponse(Call<RepositorySearch> call,
                                   Response<RepositorySearch> response) {
                mBinding.setLoading(false);
                if(response.isSuccessful() && mAdapter != null) {
                    mAdapter.updateRepositories(response.body().repositories);
                    mBinding.setEmptyData(mAdapter.getItemCount() == 0);
                }
            }

            @Override
            public void onFailure(Call<RepositorySearch> call, Throwable t) {
                mBinding.setLoading(false);
            }
        });
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onRepositorySelected(Repository repository) {
        if (mContext != null) {
            final Intent intent = new Intent(mContext, RepositoryDetailsActivity.class);
            intent.putExtra(RepositoryDetailsActivity.REPOSITORY_EXTRA, repository);
            mContext.startActivity(intent);
        }
    }
}
