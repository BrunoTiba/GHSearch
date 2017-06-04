package com.bkenji.ghsearch.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkenji.ghsearch.R;
import com.bkenji.ghsearch.databinding.ViewHolderRepositoryBinding;
import com.bkenji.ghsearch.model.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bruno Tiba on 03/06/2017.
 */

public class RepositorySearchListAdapter extends RecyclerView.Adapter<RepositorySearchListAdapter.RepositoryViewHolder> {

    private Context mContext;
    private final List<Repository> mRepositories;
    private OnRepositorySelectedListener mListener;

    public RepositorySearchListAdapter(Context context) {
        mRepositories = new ArrayList<>();
        mContext = context;
    }

    public void updateRepositories(List<Repository> repositories) {
        mRepositories.clear();
        mRepositories.addAll(repositories);
        notifyDataSetChanged();
    }

    public void setListener(OnRepositorySelectedListener listener) {
        mListener = listener;
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        final ViewHolderRepositoryBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.view_holder_repository, parent, false);
        return new RepositoryViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        final Repository repository = mRepositories.get(position);
        holder.updateRepository(repository);
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    public class RepositoryViewHolder extends RecyclerView.ViewHolder {

        private ViewHolderRepositoryBinding mBinding;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void updateRepository(Repository repository) {
            mBinding.setRepository(repository);
            mBinding.executePendingBindings();
        }

        @OnClick(R.id.repository_item)
        public void onRepositorySelected(View view) {
            if (mListener != null) {
                mListener.onRepositorySelected(mBinding.getRepository());
            }
        }
    }

    public interface OnRepositorySelectedListener {
        void onRepositorySelected(Repository repository);
    }
}
