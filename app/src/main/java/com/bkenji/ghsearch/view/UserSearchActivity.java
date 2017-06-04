package com.bkenji.ghsearch.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bkenji.ghsearch.R;
import com.bkenji.ghsearch.databinding.ActivityUserSearchBinding;
import com.bkenji.ghsearch.viewmodel.UserListAdapter;
import com.bkenji.ghsearch.viewmodel.UserSearchViewModel;

/**
 * Created by Bruno Tiba on 03/06/2017.
 */

public class UserSearchActivity extends AppCompatActivity {

    private UserListAdapter mAdapter;
    private UserSearchViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityUserSearchBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_user_search);
        mAdapter = new UserListAdapter(getApplicationContext());
        mViewModel = new UserSearchViewModel(binding, mAdapter);
        binding.recycler.setAdapter(mAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.search.setOnQueryTextListener(mViewModel);
        binding.search.setQueryHint("Search users");
        binding.search.setIconifiedByDefault(false);
    }
}
