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

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    List<UserDB> musers;
    Context mContext;

    public RecycleViewAdapter(List<UserDB> users, Context context) {
        this.musers = users;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.firstName.setText(musers.get(i).getName());
        viewHolder.Age.setText(musers.get(i).getAge());
        viewHolder.Weight.setText(musers.get(i).getWeight()+"");
    }

    @Override
    public int getItemCount() {
        return musers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        TextView firstName;
        TextView Age;
        TextView Weight;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.image);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            firstName = itemView.findViewById(R.id.first_name);
            Age = itemView.findViewById(R.id.Age);
            Weight = itemView.findViewById(R.id.Weight);
        }
    }
}