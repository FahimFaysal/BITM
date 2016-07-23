package com.acrophillic.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.acrophillic.businesstier.Manager;
import com.acrophillic.businesstier.User;
import com.acrophillic.concern.R;

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

        intent = getIntent();
        int id = intent.getIntExtra("id", 0);


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
        imageView = (ImageView) findViewById(R.id.imageViewProfile);
        tvFullName.setText(user.getFirstName()+ " "+user.getSecondName());
        tvDOB = (TextView) findViewById(R.id.textViewDOB);
//        lvPost = (ListView) findViewById(R.id.listViewPost);

    }

    private void intialization() {

        imageView = (ImageView) findViewById(R.id.imageViewProfile);
        tvFullName = (TextView) findViewById(R.id.textViewFullName);
        tvDOB = (TextView) findViewById(R.id.textViewDOB);
        lvPost = (ListView) findViewById(R.id.listViewPost);

    }
}
