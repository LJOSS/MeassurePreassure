package com.example.measurepressure;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class User extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    static final int PHOTO_REQUEST_CODE = 1;

    Button btnAdd;

    Uri UriPhoto;

    TextView tvAge;

    EditText etName, etAge, etWeight;

    ImageView ivPhoto;

    private int mYear, mMonth, mDay;

    //PARAMS OF USER
    private int Weight;

    private String Name, Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);

        etWeight = (EditText) findViewById(R.id.etWeight);

        etName = (EditText) findViewById(R.id.etName);

        etAge = (EditText) findViewById(R.id.etAge);
        etAge.setOnClickListener(this);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    public void onClickPhoto(View view) {

        try {
            String IMGS_PATH = Environment.getExternalStorageDirectory().toString() + "/Measure pressure/Photos";
            createDirectory(IMGS_PATH);

            String img_path = IMGS_PATH + "photo" + System.currentTimeMillis() + ".jpg";

            UriPhoto = Uri.fromFile(new File(img_path));

            final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, UriPhoto);

            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, PHOTO_REQUEST_CODE);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void createDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                Log.e(TAG, "ERROR: Creation of directory " + path + " failed, check does Android Manifest have permission to write to external storage.");
            }
        } else {
            Log.i(TAG, "Created directory " + path);
        }
    }

    @Override
    public void onActivityResult ( int requestCode, int resultCode, Intent data){
        //making photo
        if (requestCode == PHOTO_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            ivPhoto.setImageURI(UriPhoto);
        } else {
            Toast.makeText(this, "ERROR: Image was not obtained.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.etAge:
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etAge.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.btnAdd:
                UserDB user = new UserDB();

                Weight = Integer.parseInt(etWeight.getText().toString());
                Name = etName.getText().toString();
                Age = etAge.getText().toString();

                user.setAge(Age);
                user.setName(Name);
                user.setWeight(Weight);
                user.setAvatarURI(UriPhoto.toString());
                MainActivity.MyDB.myDAO().AddUser(user);

                Toast.makeText(this, user.getAvatarURI() + " ", Toast.LENGTH_SHORT).show();
                etWeight.setText("");
                etAge.setText("");
                etName.setText("");
                break;
        }
    }
}
