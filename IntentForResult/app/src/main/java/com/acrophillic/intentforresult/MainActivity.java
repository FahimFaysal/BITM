package com.acrophillic.intentforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static int PICK_CONTACT_REQUEST = 1;
    Button btnWidth;
    Button btnHight;
    Button btnCale;

    TextView tvArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWidth = (Button) findViewById(R.id.button1);
        btnHight = (Button) findViewById(R.id.button2);
        btnCale = (Button) findViewById(R.id.button3);

        tvArea = (TextView) findViewById(R.id.textView1);

        btnWidth.setOnClickListener(this);
        btnHight.setOnClickListener(this);
        btnCale.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == Main2Activity.REQUEST_CODE) {
                if (data.getExtras().containsKey("widthInfo")) {
                    btnWidth.setText(data.getStringExtra("widthInfo"));
                }
                if (data.getExtras().containsKey("heightInfo")) {
                    btnHight.setText(data.getStringExtra("heightInfo"));
                }
            }
        }


    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this, Main2Activity.class);
        switch (v.getId()) {

            case R.id.button1: // width
                intent.putExtra("number", "width");
                startActivityForResult(intent, PICK_CONTACT_REQUEST);
                // startActivity(intent);
                break;
            case R.id.button2:// hight
                intent.putExtra("number", "height");
                startActivityForResult(intent, PICK_CONTACT_REQUEST);
                // startActivity(intent);
                break;
            case R.id.button3:// calc
                int width = Integer.valueOf(btnWidth.getText().toString());
                int height = Integer.valueOf(btnHight.getText().toString());
                btnCale.setText(width * height + " sq ft");
                break;

            default:
                break;
        }
    }
}
