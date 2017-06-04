package com.bkenji.ghsearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bruno Tiba on 02/06/2017.
 */

public class RepositorySearch {
    @SerializedName("items")
    public List<Repository> repositories;

    @SerializedName("total_count")
    public int count;
}
