package com.acrophillic.intentforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText etNumber;
    Button btnSentInfo;
    final static int REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etNumber = (EditText) findViewById(R.id.editText1);
        btnSentInfo = (Button) findViewById(R.id.button1);

        btnSentInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        String string = etNumber.getText().toString();

        Intent intent = getIntent();

        String stMg = intent.getStringExtra("number");

        if (stMg.contentEquals("width")) {
            intent.putExtra("widthInfo", string);
            setResult(REQUEST_CODE, intent);
            finish();
        }
        if (stMg.contentEquals("height")) {
            intent.putExtra("heightInfo", string);
            setResult(REQUEST_CODE, intent);
            finish();
        }

    }
}
