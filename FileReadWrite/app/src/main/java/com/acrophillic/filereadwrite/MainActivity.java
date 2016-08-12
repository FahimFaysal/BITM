package com.acrophillic.filereadwrite;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView outPutTv;
    private EditText inputEt;
    private Button btnSave;
    private Button btnRetrieve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outPutTv = (TextView) findViewById(R.id.textView);
        inputEt = (EditText) findViewById(R.id.editText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnRetrieve = (Button) findViewById(R.id.btnRetrieve);
        btnSave.setOnClickListener(this);
        btnRetrieve.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        try {
            switch (id) {

                case R.id.btnSave:
                    String textToBeSaved = inputEt.getText().toString().trim();
                    new FileReadWrite(this).writeToFile(textToBeSaved);
                    Log.d("hey there", "hello hieml");
                    break;

                case R.id.btnRetrieve:
                    String textFromFile = new FileReadWrite(this).readFromFile();
                    outPutTv.setText(textFromFile);
                    break;
            }
        } catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


}
