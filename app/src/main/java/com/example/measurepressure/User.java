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

    static final int REQUEST_CODE_PHOTO = 1;

    Button btnAdd,btnAddGall;

    Intent pickIMG;
    Bitmap bitmap;
    ImageView IMG;

    Uri Uri;

    File directory;

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

    private void createDirectory() {
        directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Meassure Preassure Pic");
        Uri uri = Uri.fromFile(directory);
        File auxFile = new File(uri.toString());
        Toast.makeText(this,auxFile.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_CODE_PHOTO && resultCode == RESULT_OK) {
            if (intent != null && intent.getExtras() != null) {
                Bitmap imageBitmap = (Bitmap) intent.getExtras().get("data");
                ivPhoto.setImageBitmap(imageBitmap);
            }
        }
    }

    public void onClickPhoto(View view) {
        createDirectory();
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (pictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pictureIntent, REQUEST_CODE_PHOTO);
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

                MainActivity.MyDB.myDAO().AddUser(user);

                Toast.makeText(this, "Succsess", Toast.LENGTH_SHORT).show();
                etWeight.setText("");
                etAge.setText("");
                etName.setText("");
                break;
        }
    }
}
