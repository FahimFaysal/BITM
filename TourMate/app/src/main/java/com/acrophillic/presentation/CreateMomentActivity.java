package com.acrophillic.presentation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.acrophillic.business.Moment;
import com.acrophillic.persistence.ServiceMoment;
import com.acrophillic.tourmate.R;

import java.io.ByteArrayOutputStream;

public class CreateMomentActivity extends AppCompatActivity {


    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private EditText et;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_moment);

        imageView = (ImageView) findViewById(R.id.imageViewTakeShort);
        et = (EditText) findViewById(R.id.editTextMakeNote);

    }

    public void completeMoment(View view){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
        byte[] byteArray = stream.toByteArray();

        Moment moment = new Moment();
        moment.setNote(et.getText().toString());
        moment.setPicture(byteArray);


        if(new ServiceMoment(this).addMoment(moment)){
           Intent intent = new Intent(this, TourDetailActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
        }

    }

    public void opneCamera(View view) {
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
}
