package com.bkenji.ghsearch.requests;

import com.bkenji.ghsearch.model.RepositorySearch;
import com.bkenji.ghsearch.model.User;
import com.bkenji.ghsearch.model.UserSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bruno Tiba on 01/06/2017.
 */

public interface GitHubService {

    @GET("/search/repositories")
    Call<RepositorySearch> searchRepositories(@Query("q") String query);

    @GET("/search/users")
    Call<UserSearch> searchUsers(@Query("q") String user);

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<User>> getContributors(@Path("owner") String owner, @Path("repo") String repo);
}
