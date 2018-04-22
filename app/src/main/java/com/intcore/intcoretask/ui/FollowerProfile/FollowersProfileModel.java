package com.intcore.intcoretask.ui.FollowerProfile;

import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;

import java.util.List;

public interface FollowersProfileModel {

    void getTimeLinesModel(String screenName, ProfileListener profileListener);

     interface ProfileListener {
        void returnTimelines(List<TimeLine> timelines);

        void failedConnect();

    }
}
