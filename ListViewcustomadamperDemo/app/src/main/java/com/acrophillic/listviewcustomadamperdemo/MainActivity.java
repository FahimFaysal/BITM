package com.acrophillic.listviewcustomadamperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etGroup;
    private EditText etEmail;
    private EditText etPhone;

    CustomAdapter adapter;

    ListView listView;

    private ArrayList<ContactTO> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editTextName);
        etGroup = (EditText) findViewById(R.id.editTextGroup);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPhone = (EditText) findViewById(R.id.editTextPhone);

        listView = (ListView)findViewById(R.id.listView);

        contactList = new ArrayList<ContactTO>();


    }

    public void onClick(View view) {




        contactList.add(new ContactTO(etName.getText().toString(), etGroup.getText().toString(), etPhone.getText().toString(), etEmail.getText().toString()));
        adapter = new CustomAdapter(MainActivity.this, contactList);
        listView.setAdapter(adapter);

        etName.getText().clear();
        etGroup.getText().clear();
        etPhone.getText().clear();
        etEmail.getText().clear();



    }
}
