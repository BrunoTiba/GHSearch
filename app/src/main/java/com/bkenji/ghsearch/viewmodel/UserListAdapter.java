package com.bkenji.ghsearch.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bkenji.ghsearch.R;
import com.bkenji.ghsearch.databinding.ViewHolderUserBinding;
import com.bkenji.ghsearch.model.User;
import com.bkenji.ghsearch.view.UserViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno Tiba on 03/06/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context mContext;
    private List<User> mUsers;

    public UserListAdapter(Context context) {
        mContext = context;
        mUsers = new ArrayList<>();
    }

    public void updateData(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        final ViewHolderUserBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.view_holder_user, parent, false);
        return new UserViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = mUsers.get(position);
        holder.updateUser(user);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
