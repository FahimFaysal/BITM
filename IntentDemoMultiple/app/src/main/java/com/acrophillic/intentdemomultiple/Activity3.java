package com.acrophillic.intentdemomultiple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textView = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("arrayList") ;

        textView.setText("ArrayList\n"+arrayList.get(0)+"\n"+arrayList.get(1)+"\n"+arrayList.get(2)+"\n"+arrayList.get(3)+"\n"+arrayList.get(4));
    }
}
