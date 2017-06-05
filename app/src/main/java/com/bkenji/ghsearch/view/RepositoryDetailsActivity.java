package com.bkenji.ghsearch.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bkenji.ghsearch.R;
import com.bkenji.ghsearch.databinding.ActivityRepositoryDetailsBinding;
import com.bkenji.ghsearch.model.Repository;
import com.bkenji.ghsearch.viewmodel.RepositoryDetailsViewModel;
import com.bkenji.ghsearch.viewmodel.UserListAdapter;

/**
 * Created by Bruno Tiba on 04/06/2017.
 */

public class RepositoryDetailsActivity extends AppCompatActivity {

    public static final String REPOSITORY_EXTRA = "repository";

    private RepositoryDetailsViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Repository repository = getIntent().getParcelableExtra(REPOSITORY_EXTRA);
        final ActivityRepositoryDetailsBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_repository_details);
        final UserListAdapter adapter =
                new UserListAdapter(getApplicationContext());
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.setRepository(repository);
        mViewModel = new RepositoryDetailsViewModel(binding, adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
    }
}
