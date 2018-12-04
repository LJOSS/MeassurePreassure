package com.example.measurepressure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMeasure extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd;
    private EditText etPulse, etLower, etUpper, etID;

    int Lower, Upper, Pulse, ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_measure);

        btnAdd = (Button) findViewById(R.id.btnAddMeasure);

        etLower = (EditText) findViewById(R.id.etLower);
        etPulse = (EditText) findViewById(R.id.etPulse);
        etUpper = (EditText) findViewById(R.id.etUpper);
        etID = (EditText) findViewById(R.id.etID);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddMeasure:
                MeassureDB measureDB = new MeassureDB();

                Lower = Integer.parseInt(etLower.getText().toString());
                Pulse = Integer.parseInt(etPulse.getText().toString());
                Upper = Integer.parseInt(etUpper.getText().toString());
                ID = Integer.parseInt(etID.getText().toString());

                measureDB.setLower(Lower);
                measureDB.setPulse(Pulse);
                measureDB.setUpper(Upper);
                measureDB.setUserid(ID);

                MainActivity.myAppDB.meassureDAO().AddMeasure(measureDB);
                Toast.makeText(this, "Sucsess", Toast.LENGTH_LONG).show();
                etLower.setText("");
                etPulse.setText("");
                etUpper.setText("");
                break;
        }
    }
}
