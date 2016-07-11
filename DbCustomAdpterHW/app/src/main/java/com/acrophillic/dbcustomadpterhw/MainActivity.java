package com.acrophillic.dbcustomadpterhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etGroup;
    private EditText etEmail;
    private EditText etPhone;

    ContactTO contactTO;
    ContactManager manager;

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

//        contactList = new ArrayList<ContactTO>();
        manager = new ContactManager(this);
        ShowList();
    }

    public void onClick(View view) {

        String name = etName.getText().toString();
        String phoneNo = etPhone.getText().toString();

        contactTO = new ContactTO(name,etGroup.getText().toString(),phoneNo,etEmail.getText().toString());

        boolean inserted = manager.addContact(contactTO);
        if (inserted) {
            Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Failed ", Toast.LENGTH_SHORT).show();
        }

        ShowList();

    }

    public void ShowList() {

//        contactList.add(new ContactTO(etName.getText().toString(), etGroup.getText().toString(), etPhone.getText().toString(), etEmail.getText().toString()));
        contactList = manager.getAllContacts();
        adapter = new CustomAdapter(MainActivity.this, contactList);
        listView.setAdapter(adapter);

        etName.getText().clear();
        etGroup.getText().clear();
        etPhone.getText().clear();
        etEmail.getText().clear();



    }
}
