package com.example.measurepressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ShowUsersAndMeasures extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShow;
    private Button btnShowAll;
    private EditText etID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users_and_measures);

        tvShow = (TextView) findViewById(R.id.tvShowUserAndMeasure);

        etID = (EditText) findViewById(R.id.etIDShow);

        btnShowAll = (Button) findViewById(R.id.btnShowAll);
        btnShowAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShowAll:
                int id = Integer.parseInt(etID.getText().toString());

                List<UsersWithMeasures> usersWithMeasure = MainActivity.myAppDB.meassureDAO().getAllMeasuresWithUsers(id);

                String info = "";

                for (UsersWithMeasures usersWithMeasure_ : usersWithMeasure) {
                    String name = usersWithMeasure_.getName();
                    int weight = usersWithMeasure_.getWeight();
                    int upper = usersWithMeasure_.getUpper();
                    int lower = usersWithMeasure_.getLower();
                    int pulse = usersWithMeasure_.getPulse();

                    info = info + "\n\n" + "\nName: " + name + "\nWeight: " + weight + "\nUpper: " + upper + "\nLower: " + lower + "\nPulse: " + pulse;
                }
                tvShow.setText(info);
                break;
        }
    }
}
