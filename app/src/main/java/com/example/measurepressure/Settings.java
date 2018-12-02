package com.example.measurepressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        List<UserDB> users = MainActivity.myAppDB.userDAO().getUsers();

        initRecycleViewAdapter(users);
    }

    private void initRecycleViewAdapter(List<UserDB> users) {
        RecyclerView rvMain = (RecyclerView) findViewById(R.id.rvMain);
        RecycleViewAdapter adapter = new RecycleViewAdapter(users,this);
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
    }
}
