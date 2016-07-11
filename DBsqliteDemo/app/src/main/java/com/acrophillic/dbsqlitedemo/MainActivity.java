package com.acrophillic.dbsqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etGroup;
    EditText etEmail;
    TextView textView;
    ContactTO contactTO;
    ContactManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         etName = (EditText) findViewById(R.id.editTextName);
         etPhone = (EditText) findViewById(R.id.editTextPhone);
         etGroup= (EditText) findViewById(R.id.editTextGroup);
         etEmail = (EditText) findViewById(R.id.editTextEmail);

        textView = (TextView)findViewById(R.id.TextViewData);
        manager = new ContactManager(this);
//        Log.d("Calculate Area", "hey there.................");
        ShowList();
    }

    public void saveToDatabase(View view) {

        String name = etName.getText().toString();
        String phoneNo = etPhone.getText().toString();

        contactTO=new ContactTO(name,etGroup.getText().toString(),phoneNo,etEmail.getText().toString());

        boolean inserted = manager.addContact(contactTO);
        if (inserted) {
            Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Failed ", Toast.LENGTH_SHORT).show();
        }

        ShowList();

    }

    public void ShowList(){
        ArrayList<ContactTO> contacts = manager.getAllContacts();



        if(contacts != null &&!contacts.isEmpty() ) {

            for(ContactTO to: contacts){
               textView.setText(textView.getText().toString()+to.toString());
            }
            /*String name = contacts.get(0).getName();
            Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();*/
        }
    }
}
