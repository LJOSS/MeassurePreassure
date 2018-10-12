package com.example.measurepressure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Meassure extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<UserDB> users = MainActivity.MyDB.myDAO().getUsers();
        List<MeassureDB> meassures = MainActivity.MeassureDB.meassureDAO().getMeassures();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meassure);
        if (users.isEmpty()) {
            Toast.makeText(this, "Make new User", Toast.LENGTH_LONG).show();
            Intent iUser = new Intent(this, User.class);
            startActivity(iUser);
        }
        spinner = (Spinner) findViewById(R.id.Spinner);

        List<String> data;

        for(UserDB usr : users){
            data = usr.getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data);
    }
}
