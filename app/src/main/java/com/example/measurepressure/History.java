package com.example.measurepressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class History extends AppCompatActivity {

    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        tvShow = (TextView) findViewById(R.id.tvShow);

        List<UserDB> users = MainActivity.MyDB.myDAO().getUsers();

        String info = "";

        for (UserDB usr : users) {
            String name = usr.getName();
            String age = usr.getAge();
            int weight = usr.getWeight();

            info = info+ "\n\n"+"\nName: " + name + "\nAge: " + age+ "\nWeight: "+ weight;
        }
        tvShow.setText(info);
    }
}
