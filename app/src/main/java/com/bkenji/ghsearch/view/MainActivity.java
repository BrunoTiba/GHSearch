package com.bkenji.ghsearch.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bkenji.ghsearch.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_users)
    public void onUserSearchSelected(View view) {
        final Intent intent = new Intent(this, UserSearchActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_repositories)
    public void onRepositorySearchSelected(View view) {
        final Intent intent = new Intent(this, RepositorySearchActivity.class);
        startActivity(intent);
    }
}
