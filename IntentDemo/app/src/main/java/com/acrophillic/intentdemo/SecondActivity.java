package com.acrophillic.intentdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mobile App Develop on 16-6-16.
 */
public class SecondActivity extends AppCompatActivity {

    TextView tvPhone, tvEmail, tvUrl;
    String phone, email, url;
    EditText  etSmsBody, editTextEmailSubject,  etEmailCC, etEmailBCC, etEmailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvPhone = (TextView) findViewById(R.id.textViewPhone);
        tvEmail = (TextView) findViewById(R.id.textViewEmail);
        tvUrl = (TextView) findViewById(R.id.textViewUrl);


        etSmsBody= (EditText) findViewById(R.id.editTextSmsSubject);

        editTextEmailSubject= (EditText) findViewById(R.id.editTextEmailSubject);
        etEmailCC= (EditText) findViewById(R.id.editTextCC);
        etEmailBCC= (EditText) findViewById(R.id.editTextBCC);
        etEmailBody= (EditText) findViewById(R.id.editTextEmailBody);

        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        email = intent.getStringExtra("email");
        url = intent.getStringExtra("url");

        Log.d("fahim fasyaol", phone + email + url);

        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvUrl.setText(url);
    }

    public void makeCall(View view) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phone));
        startActivity(callIntent);

    }

    public void makeSms(View view) {


        String smsBody = "This is an SMS!";

        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        // Invokes only SMS/MMS clients
        smsIntent.setType("vnd.android-dir/mms-sms");
        // Specify the Phone Number
        smsIntent.putExtra("address", phone);

        // Specify the Message
        smsIntent.putExtra("sms_body", etSmsBody.getText().toString());

        // Shoot!
        startActivity(smsIntent);
    }

    public void makeEmail(View view) {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, editTextEmailSubject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, etEmailBody.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_CC, new String[] {etEmailCC.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_BCC, new String[] {etEmailBCC.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {email});
        startActivity(Intent.createChooser(emailIntent, "Send email..."));



        Toast.makeText(this, "email", Toast.LENGTH_LONG).show();
        Log.d("fahim fasyaol", url);
    }

    public void makeGo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www" + url));
        startActivity(intent);
    }
}
