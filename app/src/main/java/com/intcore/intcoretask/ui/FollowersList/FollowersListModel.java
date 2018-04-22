package com.intcore.intcoretask.ui.FollowersList;

import com.intcore.intcoretask.network.JsonModels.User;

import java.util.List;

public interface FollowersListModel {


    void getUsersList(ModelListener modelListener);

    interface ModelListener {
        void getList(List<User> users);
        void failedConnect();
    }
}
