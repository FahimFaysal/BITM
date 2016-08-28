package com.acrophillic.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.acrophillic.business.Tour;
import com.acrophillic.business.TourAdapter;
import com.acrophillic.persistence.ServiceTour;
import com.acrophillic.tourmate.R;

import java.util.ArrayList;

public class MyTourActivity extends AppCompatActivity {

   private ListView listView;
   private TourAdapter tourAdapter;



    private ArrayList<Tour> list;

    public static int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tour);



        userId = getIntent().getIntExtra("id", 0);

        Log.e("my tour id", userId+"");

        list = new ServiceTour(this).allTour(userId);

        Log.e("my tour list", list+"");


        tourAdapter = new TourAdapter(MyTourActivity.this, list);

        Log.e("check**",list.toString());

        listView = (ListView) findViewById(R.id.listViewTour);
        listView.setAdapter(tourAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), arrayList.get(i), Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MyTourActivity.this, TourDetailActivity.class);
                intent.putExtra("tour", list.get(i));
                startActivity(intent);

            }
        });



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                Intent intent = new Intent(MyTourActivity.this, CreateTourActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "this is it", Toast.LENGTH_SHORT).show();
            }
        });






    }

}
