package com.intcore.intcoretask.ui.FollowersList;

import com.intcore.intcoretask.network.JsonModels.User;

import java.util.List;

interface FollowersListView {
    void showLoading();

    void hideLoading();

    void showErrorMessage();

    void fillFollowersRecyclerView(List<User> users);
}
