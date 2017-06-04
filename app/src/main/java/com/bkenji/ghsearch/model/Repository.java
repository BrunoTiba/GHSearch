package com.bkenji.ghsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bruno Tiba on 02/06/2017.
 */

public class Repository implements Parcelable{

    @SerializedName("name")
    public String name;

    @SerializedName("full_name")
    public String fullName;

    @SerializedName("description")
    public String description;

    @SerializedName("url")
    public String url;

    @SerializedName("language")
    public String language;

    @SerializedName("owner")
    public User owner;

    protected Repository(Parcel in) {
        name = in.readString();
        fullName = in.readString();
        description = in.readString();
        url = in.readString();
        language = in.readString();
        owner = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(fullName);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(language);
        dest.writeParcelable(owner, flags);
    }
}
