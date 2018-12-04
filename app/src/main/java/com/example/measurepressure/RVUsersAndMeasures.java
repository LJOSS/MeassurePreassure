package com.example.measurepressure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class RVUsersAndMeasures extends RecyclerView.Adapter<RVUsersAndMeasures.ViewHolder> {

    List<UsersWithMeasures> musers;
    Context mContext;

    public RVUsersAndMeasures(List<UsersWithMeasures> musers, Context mContext) {
        this.musers = musers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_users_and_measures, viewGroup, false);
        RVUsersAndMeasures.ViewHolder holder = new RVUsersAndMeasures.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.Lower.setText(musers.get(i).getLower()+"");
        viewHolder.Upper.setText(musers.get(i).getUpper()+"");
        viewHolder.Pulse.setText(musers.get(i).getPulse()+"");
    }

    @Override
    public int getItemCount() {
        return musers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView Lower;
        protected TextView Upper;
        protected TextView Pulse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Upper = (TextView) itemView.findViewById(R.id.rvUpper);
            Lower = (TextView) itemView.findViewById(R.id.rvLower);
            Pulse = (TextView) itemView.findViewById(R.id.rvPulse);
        }
    }
}
