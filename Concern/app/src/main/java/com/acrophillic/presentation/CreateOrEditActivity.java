package com.acrophillic.presentation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.acrophillic.businesstier.Manager;
import com.acrophillic.businesstier.User;
import com.acrophillic.concern.R;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class CreateOrEditActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etSecondName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassWord;
    private EditText etConfirmPassWord;

    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioButton rbOther;

    private Calendar DOB;

    private String stSex;

//    Bitmap photo;

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_edit);

        initialization();
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
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] byteArray =stream.toByteArray();

        User user = new User(etFirstName.getText().toString(), etSecondName.getText().toString(), etEmail.getText().toString(), etPhone.getText().toString(), etPassWord.getText().toString(), etConfirmPassWord.getText().toString(), DOB, stSex, byteArray);


        new Manager().addNewUser(this, user);

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

        rbMale = (RadioButton) findViewById(R.id.radio_male);
        rbFemale = (RadioButton) findViewById(R.id.radio_female);
        rbOther = (RadioButton) findViewById(R.id.radio_other);

        imageView = (ImageView) this.findViewById(R.id.imageView);

    }

    public void setDOB(View view) {
        DOB = Calendar.getInstance();
        Toast.makeText(this, DOB.toString(), Toast.LENGTH_SHORT).show();
    }


}
