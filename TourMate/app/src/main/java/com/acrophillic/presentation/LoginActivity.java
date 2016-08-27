package com.acrophillic.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.acrophillic.business.Manager;
import com.acrophillic.tourmate.R;


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


        int id = getIntent().getIntExtra("id", 0);
        getIntent().getStringExtra("email");

        Log.e("fahim",  getIntent().getStringExtra("email")+"");
        if( getIntent().getStringExtra("email") != null &&  !getIntent().getStringExtra("email").isEmpty()){
            etUserName.setText( getIntent().getStringExtra("email"));
            etPassWord.setText( getIntent().getStringExtra("pass"));
            cbKeepMeLogin.setChecked(true);

            Log.e("fahim",  "************************************");
        }

    }

    public void CreateAccount(View view){
    intent = new Intent(getApplicationContext(), CreateOrEditActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
    }


    public void authenticationLogin(View view){

        try {
            Log.d("login", "i am here-----------------");
            int id = new Manager().getUserByNamePass(this, etUserName.getText().toString(), etPassWord.getText().toString());

            Log.d("login", "i am here-----------------id:"+id);


            intent = new Intent(this, MyTourActivity.class);
            intent.putExtra("id", id);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
