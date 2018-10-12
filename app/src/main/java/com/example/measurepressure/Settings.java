package com.example.measurepressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class Settings extends AppCompatActivity {

    private static final String LOG_TAG = "MYLogs";

    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        rvMain = (RecyclerView) findViewById(R.id.rvMain);

        List<UserDB> users = MainActivity.MyDB.myDAO().getUsers();

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter rvMainAdapter = new UserAdapter(users);
        rvMain.setAdapter(rvMainAdapter);
    }
}
