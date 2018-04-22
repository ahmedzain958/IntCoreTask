package com.intcore.intcoretask.ui.login;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

import static com.intcore.intcoretask.util.UserStatus.FIRST_TIME;
import static com.intcore.intcoretask.util.UserStatus.LOGGED;
import static com.intcore.intcoretask.util.UserStatus.FIRST_TIME;
import static com.intcore.intcoretask.util.UserStatus.LOGGED;

public class LoginPresenterImplementation implements LoginPresenter {
    LoginView loginView;
    LoginModel loginModel;

    public LoginPresenterImplementation(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }


    @Override
    public void checkUserStatus() {
        if (loginView != null) {
            loginModel.validateUserState(userState -> {
                if (userState.equals(FIRST_TIME))
                    loginView.firstTime();
                else if (userState.equals(LOGGED))
                    loginView.goFollowersListActivity();
            }

            );
        }
    }

    @Override
    public void failedToLogIn(TwitterException exception) {
        loginView.displayToast(exception.getMessage());
    }

    @Override
    public void loginUser(Result<TwitterSession> result) {
        loginModel.insertSharedPreference(result, new LoginModel.ModelListener() {
            @Override
            public void done() {

                loginView.goFollowersListActivity();
            }

            @Override
            public void failedToSave() {
                loginView.displayToast("failure happened");

            }
        });
    }


}
