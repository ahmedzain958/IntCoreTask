package com.intcore.intcoretask.ui.FollowerProfile;

import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;

import java.util.List;

public interface FollowersProfileView {
    void showLoading();

    void fillTimeLinesRecycler(List<TimeLine> timelines);

    void hideLoading();

    void showErrorMessage();
}
