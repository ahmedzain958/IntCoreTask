package com.intcore.intcoretask.ui.FollowersList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.intcore.intcoretask.R;
import com.intcore.intcoretask.adapters.FollowersAdapter;
import com.intcore.intcoretask.network.JsonModels.User;
import com.intcore.intcoretask.ui.FollowerProfile.FollowerProfileActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowersListActivity extends AppCompatActivity implements FollowersListView, FollowersAdapter.Listener {

    public static final String SELECTED_FOLLOWER = "selected";
    @BindView(R.id.followers_recycler)
    RecyclerView followers_recycler;
    @BindView(R.id.followers_list_progressBar)
    ProgressBar progressBar;
    private FollowersListPresenterImpl followersListPresenter;


    private FollowersAdapter myRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers_list);
        ButterKnife.bind(this);
        followers_recycler.setLayoutManager(new LinearLayoutManager(this));
        followers_recycler.setItemAnimator(new DefaultItemAnimator());

        followersListPresenter = new FollowersListPresenterImpl(this, new FollowersListModelImpl(this) {
        });
        followersListPresenter.getFollowers();


    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "failed to connect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fillFollowersRecyclerView(List<User> users) {
        myRecyclerViewAdapter = new FollowersAdapter(FollowersListActivity.this, users, this);
        followers_recycler.setAdapter(myRecyclerViewAdapter);
    }

    @Override
    public void onItemClicked(User user) {
        startActivity(new Intent(FollowersListActivity.this, FollowerProfileActivity.class).putExtra(SELECTED_FOLLOWER, user));
    }
}
