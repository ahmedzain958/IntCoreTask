package com.intcore.intcoretask.ui.FollowersList;

import com.intcore.intcoretask.network.JsonModels.User;

import java.util.List;

public class FollowersListPresenterImpl implements FollowersListPresenter {

    FollowersListView followersListView;
    FollowersListModel followersListModel;

    public FollowersListPresenterImpl(FollowersListView followersListView, FollowersListModel followersListModel) {
        this.followersListView = followersListView;
        this.followersListModel = followersListModel;
    }


    @Override
    public void getFollowers() {
        followersListView.showLoading();
        followersListModel.getUsersList(new FollowersListModel.ModelListener() {
            @Override
            public void getList(List<User> users) {
                followersListView.fillFollowersRecyclerView(users);
                followersListView.hideLoading();
            }

            @Override
            public void failedConnect() {
                followersListView.hideLoading();
                followersListView.showErrorMessage();
            }
        });
    }
}
