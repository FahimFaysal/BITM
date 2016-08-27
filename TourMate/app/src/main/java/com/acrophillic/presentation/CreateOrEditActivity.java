package com.acrophillic.presentation;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import com.acrophillic.tourmate.R;
import com.acrophillic.business.Manager;
import com.acrophillic.business.User;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;


import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class CreateOrEditActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etSecondName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassWord;
    private EditText etConfirmPassWord;
    private EditText etDOB;



    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioButton rbOther;

    private Calendar DOB;

    private String stSex;

//    Bitmap photo;


    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;

    User user = null;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_edit);


        intent = getIntent();
        user = (User) intent.getSerializableExtra("TO");
        initialization();

        if (user != null) {
            editProfile();
        }


    }

    private void editProfile() {
        etFirstName.setText(user.getFirstName());
        etSecondName.setText(user.getSecondName());
        etEmail.setText(user.getEmail());
        etPhone.setText(user.getPhone());
        etPassWord.setText(user.getPassWord());
        etConfirmPassWord.setText(user.getPassWord());
//        etDOB

        if (user.getSex().equals("Male")) {
            rbMale.setChecked(true);
        } else if (user.getSex().equals("Female")) {
            rbFemale.setChecked(true);
        } else {
            rbOther.setChecked(true);
        }

        byte[] bytes = user.getPicture();
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        imageView.setImageBitmap(bitmap);
    }

    public void CreateEditAccount(View view) {


//        convert View into Bitmap

      /*  imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();

//        convert Bitmap* into ByteArray
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();*/

//        image = (ImageView)findViewById(R.id.qrcode);


        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] byteArray = stream.toByteArray();

        String stDOB = etDOB.getText().toString();//12/12/2000

        String year = stDOB.substring(6,10);
        String month   = stDOB.substring(3,5);
        String day = stDOB.substring(0,2);

        Log.e("stcal", day+", "+month+", "+year);

        DOB  = Calendar.getInstance();

        DOB.set(Integer.parseInt(year), Integer.parseInt(month)+1, Integer.parseInt(day));

        Log.e("cal", DOB.toString());


        try {
            if (user == null) {
                user = new User(etFirstName.getText().toString(), etSecondName.getText().toString(), etEmail.getText().toString(), etPhone.getText().toString(), etPassWord.getText().toString(), etConfirmPassWord.getText().toString(), DOB, stSex, byteArray);
                new Manager().addNewUser(this, user);
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            } else {
                User updatedUser = new User(this.user.getId(), etFirstName.getText().toString(), etSecondName.getText().toString(), etEmail.getText().toString(), etPhone.getText().toString(), etPassWord.getText().toString(), etConfirmPassWord.getText().toString(), DOB, stSex, byteArray);
                new Manager().updateUserManager(this, updatedUser);
                intent = new Intent(this, LoginActivity.class);
                intent.putExtra("pass", this.user.getPassWord());///////////////////////////////////////////////
                intent.putExtra("email",this.user.getEmail());
                startActivity(intent);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_male:
                if (checked) stSex = "Male";
                break;
            case R.id.radio_female:
                if (checked) stSex = "Female";
                break;

            case R.id.radio_other:
                if (checked) stSex = "other";
                break;
        }

        Toast.makeText(this, stSex, Toast.LENGTH_SHORT).show();
    }


    public void takePicture(View view) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    private void initialization() {

        etFirstName = (EditText) findViewById(R.id.editTextFristName);
        etSecondName = (EditText) findViewById(R.id.editTextSecondName);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPhone = (EditText) findViewById(R.id.editTextPhone);
        etPassWord = (EditText) findViewById(R.id.editTextPassWord);
        etConfirmPassWord = (EditText) findViewById(R.id.editTextConfirmPassword);
        etDOB = (EditText)findViewById(R.id.editTextDOB);

    /*    etDOB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){

                    DatePickerFragment datePickerFragment = new DatePickerFragment(view);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    datePickerFragment.show(ft,"DatePicker");
                }
            }
        });*/


        rbMale = (RadioButton) findViewById(R.id.radio_male);
        rbFemale = (RadioButton) findViewById(R.id.radio_female);
        rbOther = (RadioButton) findViewById(R.id.radio_other);

        imageView = (ImageView) this.findViewById(R.id.imageView);

    }

  public void setDOB(View view) {
//        DOB = Calendar.getInstance();
//        Toast.makeText(this, DOB.toString(), Toast.LENGTH_SHORT).show();

      etDOB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
          @Override
          public void onFocusChange(View view, boolean b) {
              if(b){
                  DatePickerFragment datePickerFragment = new DatePickerFragment(view);
                  FragmentTransaction ft= getFragmentManager().beginTransaction();
                  datePickerFragment.show(ft,"DatePicker");
              }
          }
      });


    }

/*   public  void  onStart(){
        super.onStart();
//        editTextBirthDate = (EditText) findViewById(R.id.editTextBirthDate);
        etDOB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    DatePickerFragment datePickerFragment = new DatePickerFragment(view);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    datePickerFragment.show(ft,"DatePicker");
                }
            }
        });

    }*/


}
