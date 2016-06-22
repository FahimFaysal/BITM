package com.acrophillic.intentdemomultiple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        textView = (TextView)findViewById(R.id.textView3);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("bundle");


        textView.setText("Bundle\n"+bundle.getString("first")+"\n"+bundle.getString("second")+"\n"+bundle.getString("third")+"\n"+bundle.getString("forth")+"\n"+bundle.getString("fifth"));


    }
}
