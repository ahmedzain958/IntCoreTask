package com.intcore.intcoretask.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.intcore.intcoretask.R;
import com.intcore.intcoretask.ui.FollowersList.FollowersListActivity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.login_button)
    TwitterLoginButton loginButton;
    private LoginPresenterImplementation loginPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenterImpl = new LoginPresenterImplementation(this, new LoginModelImplementation() {
        });
        loginPresenterImpl.checkUserStatus();


    }

    @Override
    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goFollowersListActivity() {
        startActivity(new Intent(LoginActivity.this, FollowersListActivity.class));
    }

    @Override
    public void firstTime() {
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                loginPresenterImpl.loginUser(result);
            }

            @Override
            public void failure(TwitterException exception) {
                loginPresenterImpl.failedToLogIn(exception);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
         loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                loginPresenterImpl.loginUser(result);
            }

            @Override
            public void failure(TwitterException exception) {
                loginPresenterImpl.failedToLogIn(exception);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}
