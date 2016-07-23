package com.acrophillic.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.acrophillic.businesstier.Manager;
import com.acrophillic.concern.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassWord;

    private CheckBox cbKeepMeLogin;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         etUserName = (EditText)findViewById(R.id.editTextUserName);
         etPassWord= (EditText)findViewById(R.id.editTextPassWord);

         cbKeepMeLogin = (CheckBox)findViewById(R.id.checkBox);

    }

    public void CreateAccount(View view){
    intent = new Intent(getApplicationContext(), CreateOrEditActivity.class);
    startActivity(intent);
    }


    public void authenticationLogin(View view){

        try {
            Log.d("login", "i am here-----------------");
            int id = new Manager().getUserByNamePass(this, etUserName.getText().toString(), etPassWord.getText().toString());

            intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void GetPass(View view) {
        Toast.makeText(this, "Please contact with admin for now", Toast.LENGTH_SHORT).show();
    }
}
