package com.intcore.intcoretask.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.intcore.intcoretask.R;
import com.intcore.intcoretask.network.JsonModels.timelines.TimeLine;

import java.util.List;

/**
 * Created by Zain on 10/02/2018.
 */

public class TimeLinesAdapter extends RecyclerView.Adapter<TimeLinesAdapter.ViewHolder> {

    List<TimeLine> timeLines;
    Context mContext;

    public TimeLinesAdapter(Context context, List<TimeLine> timeLines) {
        this.timeLines = timeLines;
        mContext = context;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView created_at, text;

        public ViewHolder(View itemView) {
            super(itemView);
            this.created_at = itemView.findViewById(R.id.created_at);
            this.text = itemView.findViewById(R.id.text);
        }

        public void bind(final TimeLine timeLine) {
            if (timeLine != null) {
                created_at.setText(timeLine.getCreatedAt());
                text.setText(timeLine.getText());
            }
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timeline_recycler_item, parent, false);


        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        holder.bind(timeLines.get(listPosition));
    }

    public void clear() {
        if (timeLines != null)
            timeLines.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (timeLines != null)
            if (timeLines.size() > 0)
                return timeLines.size();
        return 0;
    }

}

