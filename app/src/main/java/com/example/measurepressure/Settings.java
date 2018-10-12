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

        List<UserDB> users = MainActivity.MyDB.myDAO().getUsers();

        rvMain =(RecyclerView) findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        Log.d(LOG_TAG,"WORK HERE");
        MyRVAdapter rvMainAdapter = new MyRVAdapter(users);
        rvMain.setAdapter(rvMainAdapter);
    }
}
