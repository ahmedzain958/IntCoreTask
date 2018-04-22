package com.intcore.intcoretask.ui.login;

import com.intcore.intcoretask.app.AppApplication;
import com.intcore.intcoretask.util.UserStatus;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import static com.intcore.intcoretask.util.UserStatus.FIRST_TIME;
import static com.intcore.intcoretask.util.UserStatus.LOGGED;

public class LoginModelImplementation implements LoginModel {


    UserStatus userStatus;

    public LoginModelImplementation() {
        userStatus = AppApplication.getInstance().getUserStatus();
    }


    @Override
    public void validateUserState(Listener modelListener) {
        if (userStatus.getFirstTime()) {
            modelListener.getUserState(FIRST_TIME);
        } else if (userStatus.getLogged()) {
            modelListener.getUserState(LOGGED);
        }
    }

    @Override
    public void insertSharedPreference(Result<TwitterSession> result, ModelListener listener) {
        TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();
        String token = authToken.token;
        String secret = authToken.secret;
        String name = session.getUserName();

        if (userStatus.loginUser(token, secret, name)) {
            listener.done();
        } else {
            listener.failedToSave();
        }

    }
}
