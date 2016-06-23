package com.acrophillic.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PoetActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poet);

        tvName = (TextView) findViewById(R.id.textViewName);
        tvDescription = (TextView) findViewById(R.id.textViewDescription);

        Intent intent = getIntent();
       Poet poet = (Poet) intent.getSerializableExtra("poet");
        tvName.setText(poet.getName());
        tvDescription.setText(poet.getDescription());

    }
}
