package com.intcore.intcoretask.ui.FollowerProfile;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;


import com.intcore.intcoretask.R;
import com.intcore.intcoretask.app.Constants;
import com.intcore.intcoretask.network.FollowersApi;
import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;
import com.intcore.intcoretask.util.UserStatus;
import com.intcore.intcoretask.util.UserStatusModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.intcore.intcoretask.util.UserStatus.getUserStatusModel;


public class FollowersProfileModelImpl implements FollowersProfileModel {
    Context context;

    public FollowersProfileModelImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getTimeLinesModel(String screenName, ProfileListener profileListener) {
        Converter.Factory converter = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(converter)
                .build();

        new UserStatus(context);
        UserStatusModel userStatusModel = getUserStatusModel();

        String authorization =
                "OAuth oauth_consumer_key=\"OmCu9cH9ogT95mJEwhSyVCHEZ\",oauth_token=\"986590495731343361-Fegwg2mQVltu0rvutMfwIjpzQN5QTDU\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1524451808\",oauth_nonce=\"nEUe41K7IwG\",oauth_version=\"1.0\",oauth_signature=\"ADhhWngYrlHpgG2dSJCR74%2Fti4o%3D\"";


        final FollowersApi followersApi = retrofit.create(FollowersApi.class);
        followersApi.getTimeLines(authorization, "22mosalah", 10).enqueue(new Callback<List<TimeLine>>() {//get list of foods
            @Override
            public void onResponse(Call<List<TimeLine>> call, Response<List<TimeLine>> response) {
                if (response != null) {
                    profileListener.returnTimelines(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<TimeLine>> call, Throwable t) {
                Log.d("logMessage", t.getMessage());
                profileListener.failedConnect();
            }
        });
    }
}
