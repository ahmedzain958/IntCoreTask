package com.intcore.intcoretask.ui.FollowerProfile;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.intcore.intcoretask.R;
import com.intcore.intcoretask.adapters.TimeLinesAdapter;
import com.intcore.intcoretask.network.JsonModels.User;
import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.intcore.intcoretask.ui.FollowersList.FollowersListActivity.SELECTED_FOLLOWER;


public class FollowerProfileActivity extends AppCompatActivity implements FollowersProfileView {
    @BindView(R.id.profile_image)
    ImageView profile_image;

    @BindView(R.id.profile_background_image)
    ImageView profile_background_image;

    @BindView(R.id.tweets_recycler)
    RecyclerView tweets_recycler;


    @BindView(R.id.profile_progressBar)
    ProgressBar progressBar;


    private FollowersProfilePresenterImpl followersProfilePresenterImpl;
    private TimeLinesAdapter timelinesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_profile);
        ButterKnife.bind(this);
        tweets_recycler.setLayoutManager(new LinearLayoutManager(this));

        followersProfilePresenterImpl = new FollowersProfilePresenterImpl(this, new FollowersProfileModelImpl(this) {
        });


        if (getIntent() != null && getIntent().hasExtra(SELECTED_FOLLOWER)) {
            Bundle data = getIntent().getExtras();
            User user = data.getParcelable(SELECTED_FOLLOWER);
            if (user != null) {
                if (user.getProfileImageUrl() != null && !user.getProfileImageUrl().equals("")
                        && !user.getProfileImageUrl().equals("http://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png")) {
                    Picasso.with(this).load(user.getProfileImageUrl()).into(profile_image);
                } else {
                    Picasso.with(this).load(R.drawable.imd).into(profile_image);
                }
                if (user.getProfileBackgroundImageUrl() != null && !user.getProfileBackgroundImageUrl().equals("")) {
                    Picasso.with(this).load((Uri) user.getProfileBackgroundImageUrl()).into(profile_background_image);
                } else {
                    Picasso.with(this).load(R.drawable.imd).into(profile_background_image);
                }
                followersProfilePresenterImpl.getTimelines(user.getScreenName());


//                final UserTimeline userTimeline = new UserTimeline.Builder()
//                        .screenName(user.getScreenName())
//                        .build();
//                final TweetTimelineRecyclerViewAdapter adapter = new TweetTimelineRecyclerViewAdapter.Builder(this)
//                        .setTimeline(userTimeline)
//                        .build();
//                tweets_recycler.setAdapter(adapter);

            }
        }


    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void fillTimeLinesRecycler(List<TimeLine> timelines) {
        timelinesAdapter = new TimeLinesAdapter(this, timelines);
        tweets_recycler.setAdapter(timelinesAdapter);
    }


    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "failed to connect", Toast.LENGTH_SHORT).show();
    }
}
