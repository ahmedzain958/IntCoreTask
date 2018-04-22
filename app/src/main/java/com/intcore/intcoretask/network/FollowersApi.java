package com.intcore.intcoretask.network;

import com.intcore.intcoretask.network.JsonModels.TwitterResult;
import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface FollowersApi {
    @GET("followers/list.json")
    Call<TwitterResult> getFollowersList(@Header("Authorization") String Authorization, @Query("name") String name);

    @GET("statuses/user_timeline.json?")
    Call<List<TimeLine>> getTimeLines(@Header("Authorization") String Authorization, @Query("screen_name") String screen_name,  @Query("count") int count);

}
