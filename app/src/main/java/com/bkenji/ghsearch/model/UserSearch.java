package com.bkenji.ghsearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bruno Tiba on 02/06/2017.
 */

public class UserSearch {
    @SerializedName("total_count")
    public int count;

    @SerializedName("items")
    public List<User> users;
}
