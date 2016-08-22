package com.acrophillic.presentation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.acrophillic.business.Manager;
import com.acrophillic.business.User;
import com.acrophillic.tourmate.R;

import java.text.SimpleDateFormat;

public class ProfileActivity extends AppCompatActivity {


    private ImageView imageView;
    private TextView tvFullName;
    private TextView tvDOB;
    private ListView lvPost;

    private Intent intent;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        intialization();

        int id = getIntent().getIntExtra("id", 0);


        try {
            Log.d("sys====", "let me set here*****************************00");
            user = new Manager().getUserByIdManger(this, id);
            Log.d("sys====", "let me set here*****************************12");
            setProfile();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setProfile() {
        Log.d("sys", "let me set here.....................");

        byte [] bytes = user.getPicture();
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//        Bitmap photo = (Bitmap) user.getPicture();
        imageView.setImageBitmap(bitmap);

//        imageView.setImageBitmap(user.getDOB());
        tvFullName.setText(user.getFirstName()+ " "+user.getSecondName());

//        new SimpleDateFormat("MMM").format(cal.getTime())
        tvDOB.setText(new SimpleDateFormat("dd-MMM-yyyy").format(user.getDOB().getTime()).toString());
//        lvPost = (ListView) findViewById(R.id.listViewPost);

    }

    private void intialization() {

        imageView = (ImageView) findViewById(R.id.imageViewProfile);
        tvFullName = (TextView) findViewById(R.id.textViewFullName);
        tvDOB = (TextView) findViewById(R.id.textViewDOB);
//        lvPost = (ListView) findViewById(R.id.listViewPost);

    }

    public void editProfile(View view) {

        intent = new Intent(this, CreateOrEditActivity.class);
        intent.putExtra("TO", user);
        startActivity(intent);
//        intent.p



    }
}
