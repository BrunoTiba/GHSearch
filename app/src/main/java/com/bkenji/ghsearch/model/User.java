package com.bkenji.ghsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno Tiba on 02/06/2017.
 */

public class User implements Parcelable {
    @SerializedName("login")
    public String name;

    @SerializedName("avatar_url")
    public String profileUrl;

    protected User(Parcel in) {
        name = in.readString();
        profileUrl = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(profileUrl);
    }
}
