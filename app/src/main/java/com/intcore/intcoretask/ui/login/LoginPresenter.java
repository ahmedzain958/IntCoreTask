package com.intcore.intcoretask.ui.login;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

public interface LoginPresenter {
    void failedToLogIn(TwitterException exception);

    void checkUserStatus();

    void loginUser(Result<TwitterSession> result);
}
