package com.acrophillic.intentdemomultiple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String string[] = intent.getStringArrayExtra("array");

        tv.setText("The Array Element:\n"+ string[0]+"\n"+string[1]+"\n"+string[2]+"\n"+string[3]+"\n"+string[4]);


    }
}
