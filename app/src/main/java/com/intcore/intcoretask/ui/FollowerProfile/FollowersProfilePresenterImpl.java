package com.intcore.intcoretask.ui.FollowerProfile;

import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;

import java.util.List;

public class FollowersProfilePresenterImpl implements FollowersProfilePresenter {

    FollowersProfileView followersProfileView;
    FollowersProfileModel followersProfileModel;

    public FollowersProfilePresenterImpl(FollowersProfileView followersProfileView, FollowersProfileModel followersProfileModel) {
        this.followersProfileView = followersProfileView;
        this.followersProfileModel = followersProfileModel;
    }


    @Override
    public void getTimelines(String screenName) {
        followersProfileView.showLoading();
        followersProfileModel.getTimeLinesModel(screenName,  new FollowersProfileModel.ProfileListener() {
            @Override
            public void returnTimelines(List<TimeLine> timelines) {
                followersProfileView.fillTimeLinesRecycler(timelines);
            }

            @Override
            public void failedConnect() {
                followersProfileView.hideLoading();
                followersProfileView.showErrorMessage();
            }
        });

    }
}
