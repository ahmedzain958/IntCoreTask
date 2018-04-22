package com.intcore.intcoretask.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static com.intcore.intcoretask.app.Constants.TWITTER_SHARED_PREFERENCE;

/**
 * Created by Zain on 29/01/2018.
 */

public class UserStatus {
    public static final String LOGGED = "logged";
    public static final String TOKEN = "access_token";
    public static final String SECRET = "secret";
    public static final String FIRST_TIME = "first_time";
    private static final String USER_NAME = "name";


    static SharedPreferences pref;
    static SharedPreferences.Editor edit;
    Context context;

    public UserStatus(Context mContext) {
        this.pref = mContext.getSharedPreferences(TWITTER_SHARED_PREFERENCE, MODE_PRIVATE);
        edit = pref.edit();
        context = mContext;
    }

    public static SharedPreferences getSharedPreference() {
        return pref;
    }

    public static boolean loginUser(String token, String secret, String name) {
        try {
            edit.putBoolean(LOGGED, true);//logged = true
            edit.putString(TOKEN, token);
            edit.putString(SECRET, secret);
            edit.putString(USER_NAME, name);
            edit.putBoolean(FIRST_TIME, false);
            edit.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean getFirstTime() {
        return getSharedPreference().getBoolean(FIRST_TIME, true);
    }

    public static UserStatusModel getUserStatusModel() {
        UserStatusModel userStatusModel = new UserStatusModel();
        SharedPreferences sharedPreferences = getSharedPreference();
        userStatusModel.logged = sharedPreferences.getBoolean(LOGGED, false);
        userStatusModel.token = sharedPreferences.getString(TOKEN, "");
        userStatusModel.secret = sharedPreferences.getString(SECRET, "");
        userStatusModel.name = sharedPreferences.getString(USER_NAME, "");
        userStatusModel.firstTime = sharedPreferences.getBoolean(FIRST_TIME, true);
        return userStatusModel;
    }

    public static boolean getLogged() {
        return getSharedPreference().getBoolean(LOGGED, false);
    }


}
