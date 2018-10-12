package com.example.measurepressure;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<UserDB> users;

    public UserAdapter(List<UserDB> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.firstName.setText(users.get(position).getName());
        holder.Age.setText(users.get(position).getAge());
        holder.Weight.setText(users.get(position).getWeight());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName;
        TextView Age;
        TextView Weight;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            Age = itemView.findViewById(R.id.Age);
            Weight = itemView.findViewById(R.id.Weight);
        }
    }
}
