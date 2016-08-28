package com.acrophillic.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.acrophillic.business.Moment;
import com.acrophillic.business.MomentAdapter;
import com.acrophillic.business.Tour;
import com.acrophillic.business.TourAdapter;
import com.acrophillic.persistence.ServiceMoment;
import com.acrophillic.persistence.ServiceTour;
import com.acrophillic.tourmate.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TourDetailActivity extends AppCompatActivity {


    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvPlace;
    private TextView tvBdget;
    private ListView lv;
    MomentAdapter momentAdapter;
    private ArrayList<Moment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);

        Tour tour = (Tour) getIntent().getSerializableExtra("tour");

         tvTitle = (TextView) findViewById(R.id.textViewName);
         tvDate = (TextView) findViewById(R.id.textViewDate);
         tvPlace = (TextView) findViewById(R.id.textViewplace);
         tvBdget = (TextView) findViewById(R.id.textViewBudget);

        lv = (ListView) findViewById(R.id.listViewMoment);


         tvTitle.setText(tour.getTourName());
         tvDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(tour.getStartDate().getTime()).toString()+" to "+new SimpleDateFormat("dd/MM/yyyy").format(tour.getEndDate().getTime()).toString());
         tvPlace.setText(tour.getToPlace()+" to "+tour.getFromPlace());
         tvBdget.setText(tour.getBudget()+"");

        list = new ServiceMoment(this).allMoment(12);//tourID

        Log.e("my tour list", list+"");


        momentAdapter = new MomentAdapter(getApplicationContext(), list);
        lv = (ListView) findViewById(R.id.listViewMoment);
       lv.setAdapter(momentAdapter);

    }

    public void CreateMoment(View view){
        Intent intent = new Intent(this, CreateMomentActivity.class);
        startActivity(intent);
    }
}
