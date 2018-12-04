package com.example.measurepressure;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowUsersAndMeasures extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spnUser;
    private TextView tvAge_show, tvNameShow, tvWeight_show;
    private CircleImageView circleImageViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users_and_measures);

        spnUser = (Spinner) findViewById(R.id.spnUsers);

        tvAge_show = (TextView) findViewById(R.id.tvAge_show);
        tvNameShow = (TextView) findViewById(R.id.tvName_show);
        tvWeight_show = (TextView) findViewById(R.id.tvWeight_show);
        circleImageViewShow = (CircleImageView) findViewById(R.id.civShow);

        List<UserDB> userDBList = MainActivity.myAppDB.userDAO().getUsers();
        List<String> Users = new ArrayList<>();
        for (UserDB usr : userDBList) {
            Users.add(usr.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_layout,
                R.id.tvNameSpinner,
                Users);
        spnUser.setAdapter(adapter);

        spnUser.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        List<UsersWithMeasures> usersWithMeasure = MainActivity.myAppDB.meassureDAO().getAllMeasuresWithUsers(++i);

        tvNameShow.setText(usersWithMeasure.get(i).getName());
        tvAge_show.setText(usersWithMeasure.get(i).getAge());
        tvWeight_show.setText(usersWithMeasure.get(i).getWeight() + " ");
        circleImageViewShow.setImageURI(Uri.parse(usersWithMeasure.get(i).getAvatarURI()));

        initRecycleViewAdapter(usersWithMeasure);
    }

    private void initRecycleViewAdapter(List<UsersWithMeasures> usersWithMeasure) {
        RecyclerView rvShowUsersAndMeasures = (RecyclerView) findViewById(R.id.rvShowUsersAndMeasures);
        RVUsersAndMeasures adapter = new RVUsersAndMeasures(usersWithMeasure, this);
        rvShowUsersAndMeasures.setAdapter(adapter);
        rvShowUsersAndMeasures.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
