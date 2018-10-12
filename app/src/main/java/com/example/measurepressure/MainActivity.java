package com.example.measurepressure;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUser, btnHistory, btnSettings, btnMeassure;

    public static MyAppDB MyDB;
    //public static MyAppDBMeassure MeassureDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHistory = (Button) findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(this);
        btnMeassure = (Button) findViewById(R.id.btnMeassure);
        btnMeassure.setOnClickListener(this);
        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(this);
        btnUser = (Button) findViewById(R.id.btnUser);
        btnUser.setOnClickListener(this);

        MyDB = Room.databaseBuilder(getApplicationContext(), MyAppDB.class, "UsersTable").allowMainThreadQueries().build();
        //MeassureDB = Room.databaseBuilder(getApplicationContext(),MyAppDBMeassure.class,"MeassureTable").allowMainThreadQueries().build();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHistory:
                Intent iHistory = new Intent(this, History.class);
                startActivity(iHistory);
                break;
            case R.id.btnUser:
                Intent iUser = new Intent(this, User.class);
                startActivity(iUser);
                break;
            case R.id.btnMeassure:
                Intent iMeassure = new Intent(this, Meassure.class);
                startActivity(iMeassure);
                break;
            case R.id.btnSettings:
                Intent iSettings = new Intent(this, Settings.class);
                startActivity(iSettings);
                break;
        }
    }
}
