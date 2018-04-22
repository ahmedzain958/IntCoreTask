package com.intcore.intcoretask.app;

import android.app.Application;
import android.content.Context;

import com.intcore.intcoretask.util.UserStatus;
import com.twitter.sdk.android.core.Twitter;


public class AppApplication extends Application {
    private static Context context;
    static AppApplication instance;
    public static UserStatus userStatus;
    public static AppApplication getInstance() {
        return instance;
    }
    public static Context getAppContext() {
        return AppApplication.context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        AppApplication.context = getApplicationContext();
        Twitter.initialize(this);
        instance = this;

       /* TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(getResources().getString(R.string.twitterCONSUMER_KEY)
                        ,getResources().getString(R.string.twitterCONSUMER_SECRET) ))
                .debubg(true)
                .build();*/
         userStatus = new UserStatus(this);

    }

    public static UserStatus getUserStatus() {
        if (userStatus == null) {
            userStatus = new UserStatus(instance);
        }
        return userStatus;
    }

}
