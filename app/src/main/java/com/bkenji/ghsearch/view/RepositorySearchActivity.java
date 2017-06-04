package com.bkenji.ghsearch.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bkenji.ghsearch.R;
import com.bkenji.ghsearch.databinding.ActivityRepositorySearchBinding;
import com.bkenji.ghsearch.viewmodel.RepositorySearchListAdapter;
import com.bkenji.ghsearch.viewmodel.RepositorySearchViewModel;

/**
 * Created by Bruno Tiba on 03/06/2017.
 */

public class RepositorySearchActivity extends AppCompatActivity {

    private RepositorySearchListAdapter mAdapter;
    private RepositorySearchViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityRepositorySearchBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_repository_search);
        mAdapter = new RepositorySearchListAdapter(getApplicationContext());
        mViewModel = new RepositorySearchViewModel(this, binding, mAdapter);
        binding.recycler.setAdapter(mAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.search.setOnQueryTextListener(mViewModel);
        binding.search.setQueryHint("Search repositories");
        binding.search.setIconifiedByDefault(false);
    }
}
