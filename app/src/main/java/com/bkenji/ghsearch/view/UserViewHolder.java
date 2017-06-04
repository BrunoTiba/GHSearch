package com.bkenji.ghsearch.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.bkenji.ghsearch.databinding.ViewHolderUserBinding;
import com.bkenji.ghsearch.model.User;

/**
 * Created by Bruno Tiba on 03/06/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private ViewHolderUserBinding mBinding;

    public UserViewHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    public void updateUser(User user) {
        mBinding.setUser(user);
        mBinding.executePendingBindings();
    }

}
