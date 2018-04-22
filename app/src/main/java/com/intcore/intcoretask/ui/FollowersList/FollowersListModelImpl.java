
package com.intcore.intcoretask.ui.FollowersList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.intcore.intcoretask.R;
import com.intcore.intcoretask.app.Constants;
import com.intcore.intcoretask.database.MySQliteOpenHelper;
import com.intcore.intcoretask.network.FollowersApi;
import com.intcore.intcoretask.network.JsonModels.TwitterResult;
import com.intcore.intcoretask.network.JsonModels.User;
import com.intcore.intcoretask.util.UserStatus;
import com.intcore.intcoretask.util.UserStatusModel;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.intcore.intcoretask.database.DBMethods.countRecords;
import static com.intcore.intcoretask.database.DBMethods.delete;
import static com.intcore.intcoretask.database.DBMethods.insert;
import static com.intcore.intcoretask.database.DBMethods.selectByTable;
import static com.intcore.intcoretask.database.DatabaseConst.BIO;
import static com.intcore.intcoretask.database.DatabaseConst.FOLLOWER;
import static com.intcore.intcoretask.database.DatabaseConst.IMAGE_URL;
import static com.intcore.intcoretask.database.DatabaseConst.NAME;
import static com.intcore.intcoretask.util.UserStatus.getUserStatusModel;

public class FollowersListModelImpl implements FollowersListModel {
    private final MySQliteOpenHelper mySQliteOpenHelper;
    Context context;

    private static final SecureRandom RAND = new SecureRandom();

    public FollowersListModelImpl(Context context) {
        this.context = context;
        mySQliteOpenHelper = MySQliteOpenHelper.getInstance(context);
    }


    @Override
    public void getUsersList(final ModelListener modelListener) {
        Converter.Factory converter = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(converter)
                .build();

       UserStatus userStatus = new UserStatus(context);
        UserStatusModel userStatusModel = getUserStatusModel();//oauth_timestamp="1524369974",


        /*String authorization = "OAuth oauth_consumer_key=\"" + context.getResources().getString(R.string.com_twitter_sdk_android_CONSUMER_KEY)
                + "\", oauth_nonce=\"11280886336670887418037667009240\", oauth_signature=\"gsCy5a4u9sgJO4mhr9PeyjbnXTo%3D\", " +
                "oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=\""+getTimestamp()+"\", oauth_token=\"" +
                userStatusModel.token + "\", oauth_version=\"1.0\"";*/
  String authorization = "OAuth oauth_consumer_key=\"OmCu9cH9ogT95mJEwhSyVCHEZ\",oauth_token=\"986590495731343361-Fegwg2mQVltu0rvutMfwIjpzQN5QTDU\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1524387469\",oauth_nonce=\"8RT4L1P3IzO\",oauth_signature=\"C38QTRDHaEH5N5PHdcXmBGTJpPk%3D\"";


       /*  String authorization = "OAuth oauth_consumer_key=\"" + context.getString(R.string.com_twitter_sdk_android_CONSUMER_KEY)
                + "\",oauth_token=\"" + userStatusModel.token +
                "\",oauth_signature_method=\"HMAC-SHA1\",oauth_version=\"1.0\",oauth_timestamp=\"" + getTimestamp()
                + "\",oauth_nonce=\"" + getNonce() + "\",oauth_signature=\"AewUrWIM0549YfWi0GOfTDZsODg%3D\",oauth_signature=\"xGRIU8zY0zOCU51hR0V7UhPfC4k%3D\"";
*/
        final FollowersApi followersApi = retrofit.create(FollowersApi.class);

        if (isNetworkAvailable()) {

            followersApi.getFollowersList(authorization, userStatusModel.name).enqueue(new Callback<TwitterResult>() {//get list of foods
                @Override
                public void onResponse(Call<TwitterResult> call, Response<TwitterResult> response) {
                    if (response != null) {
                        TwitterResult twitterResult = response.body();
                        if (twitterResult != null) {
                            List<User> users = twitterResult.getUsers();
                            if (countRecords(mySQliteOpenHelper, FOLLOWER, false, "") > 0)
                                delete(mySQliteOpenHelper, FOLLOWER, "");
                            for (User user : users) {
                                ContentValues cv = new ContentValues();
                                cv.put("ID", user.getId());
                                cv.put(NAME, user.getName());
                                cv.put(BIO, user.getDescription());
                                cv.put(IMAGE_URL, user.getProfileImageUrl());
                                insert(mySQliteOpenHelper, FOLLOWER, cv);
                            }
                            modelListener.getList(users);
                        }
                    }
                }

                @Override
                public void onFailure(Call<TwitterResult> call, Throwable t) {
                    modelListener.failedConnect();
                }
            });
        } else {
            List<User> users = new ArrayList<>();
            Cursor c = selectByTable(mySQliteOpenHelper, FOLLOWER, false, "");
            if (c != null && c.getCount() > 0) {
                while (c.moveToNext()) {
                    User user = new User();
                    user.id = c.getInt(c.getColumnIndex("ID"));
                    user.name = c.getString(c.getColumnIndex(NAME));
                    user.description = c.getString(c.getColumnIndex(BIO));
                    user.profileImageUrl = c.getString(c.getColumnIndex(IMAGE_URL));
                    users.add(user);
                }
            }
            modelListener.getList(users);
        }
    }


    public boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public static String getTimestamp() {
        final long secondsFromEpoch = System.currentTimeMillis() / 1000;
        return Long.toString(secondsFromEpoch);
    }

    public String getNonce() {
        return String.valueOf(System.nanoTime()) + String.valueOf(Math.abs(RAND.nextLong()));
    }
}
