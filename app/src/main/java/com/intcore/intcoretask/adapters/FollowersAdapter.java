package com.intcore.intcoretask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.intcore.intcoretask.R;
import com.intcore.intcoretask.network.JsonModels.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Zain on 10/02/2018.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.ViewHolder> {

    List<User> users;
    Context mContext;
    Listener listener;

    public FollowersAdapter(Context context, List<User> users, Listener listener) {
        this.users = users;
        mContext = context;
        this.listener = listener;
    }



    public interface Listener {
        void onItemClicked(User user);

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, bio_description;
        ImageView profile_image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.bio_description = itemView.findViewById(R.id.bio_description);
            this.profile_image = itemView.findViewById(R.id.profile_image);
        }

        public void bind(final User user, final Listener listener) {
            if (user != null) {
                name.setText(user.getName());
                if (user.getDescription() != null && !user.getDescription().trim().equals(""))
                    bio_description.setText(user.getDescription());
                Picasso.with(mContext).load(user.getProfileImageUrl()).into(profile_image);

            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (user != null && listener != null)
                        listener.onItemClicked(user);
                }
            });

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.follower_recycler_item, parent, false);


        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        holder.bind(users.get(listPosition), listener);
    }

    public void clear() {
        if (users != null)
            users.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<User> list) {
        users.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (users != null)
            if (users.size() > 0)
                return users.size();
        return 0;
    }

}

