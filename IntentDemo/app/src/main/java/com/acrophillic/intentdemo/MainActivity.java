package com.acrophillic.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etFirst, etSecond, etThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirst = (EditText) findViewById(R.id.textView);
        etSecond = (EditText) findViewById(R.id.textView2);
        etThird = (EditText) findViewById(R.id.textView3);
    }


    public void fullName(View view) {
       Intent intent = new Intent(this, SecondActivity.class);
        String st = etFirst.getText().toString() +" "+ etSecond.getText().toString() +" "+ etThird.getText().toString();

        intent.putExtra("phone", etFirst.getText().toString());
        intent.putExtra("email", etSecond.getText().toString());
        intent.putExtra("url", etThird.getText().toString());

        if(!etFirst.getText().toString().isEmpty() && !etSecond.getText().toString().isEmpty()) {
            startActivity(intent);
        }else{
            Toast.makeText(this, "Please Cheeck Mail ID and Phone Number", Toast.LENGTH_LONG).show();
        }
        Log.d("fahim", "faysal...................." + st);
       /* Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0377778888"));
        startActivity(callIntent);*/
    }
}
