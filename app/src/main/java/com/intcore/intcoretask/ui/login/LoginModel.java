package com.intcore.intcoretask.ui.login;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterSession;

public interface LoginModel {

    void validateUserState(Listener listener);



    void insertSharedPreference(Result<TwitterSession> result, ModelListener listener);


    interface Listener {
        void getUserState(String userState);
    }

    interface ModelListener {
        void done();
        void failedToSave();
    }


}
