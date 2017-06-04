package com.bkenji.ghsearch.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bruno Tiba on 02/06/2017.
 */

public class GitHubProvider {

    private static final String BASE_URL = "https://api.github.com";

    public static GitHubService getGithubService() {
        return Instance.GET.instance();
    }

    private enum Instance {
        GET;

        private GitHubService mInstance;

        Instance() {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mInstance = retrofit.create(GitHubService.class);
        }

        private GitHubService instance() {
            return mInstance;
        }
    }

}
