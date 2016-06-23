package com.acrophillic.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AndroidListView extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_list_view);

        listView = (ListView)findViewById(R.id.list);

        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Mr.");
        arrayList.add("Fahim");
        arrayList.add("Fayal");
        arrayList.add("Himel");

        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arrayList.get(i), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }



}
