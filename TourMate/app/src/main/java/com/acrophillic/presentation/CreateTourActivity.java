package com.acrophillic.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.acrophillic.business.Cost;
import com.acrophillic.business.Tour;
import com.acrophillic.persistence.ServiceTour;
import com.acrophillic.tourmate.R;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTourActivity extends AppCompatActivity {


    EditText etName;
    EditText etStartDate;
    EditText etEndDate;
    EditText etStartPlace;
    EditText etEndPlace;
    EditText etBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);


        etName = (EditText) findViewById(R.id.editTextEventName);
        etStartDate = (EditText) findViewById(R.id.editTextStartDate);
        etEndDate = (EditText) findViewById(R.id.editTextEndDate);
        etStartPlace = (EditText) findViewById(R.id.editTextStartPlace);
        etEndPlace = (EditText) findViewById(R.id.editTextVisitingPlace);
        etBudget = (EditText) findViewById(R.id.editTextBudget);


    }


    public void CreateTour(View view) {
        Log.e("test", "I am hree.....................");
        Tour tour = new Tour();

        tour.setUsrId(new MyTourActivity().userId);


        tour.setTourName(etName.getText().toString());
        tour.setBudget(Integer.parseInt(etBudget.getText().toString()));

      /*  ArrayList <Cost> list = new ArrayList<>();
        Cost cost = new Cost();
        cost.setCostAmmount(1212);
        cost.setCostName("hello");
        list.add(cost);

        tour.setCostArrayList(list);*/



        tour.setFromPlace(etStartPlace.getText().toString());
        tour.setToPlace(etEndPlace.getText().toString());

        Calendar startDate = Calendar.getInstance();

        String st = etStartDate.getText().toString();//12/12/2000
        String year = st.substring(6, 10);
        String month = st.substring(3, 5);
        String day = st.substring(0, 2);

        startDate.set(Integer.parseInt(year), Integer.parseInt(month) + 1, Integer.parseInt(day));
        tour.setStartDate(startDate);


        Calendar endDate = Calendar.getInstance();

        st = etEndDate.getText().toString();//12/12/2000
        year = st.substring(6, 10);
        month = st.substring(3, 5);
        day = st.substring(0, 2);

        endDate.set(Integer.parseInt(year), Integer.parseInt(month) + 1, Integer.parseInt(day));
        tour.setEndDate(endDate);


        boolean b = new ServiceTour(this).addTour(tour);

        if(b){
            Intent intent = new Intent(this, MyTourActivity.class);
            startActivity(intent);
            Toast.makeText(this, "okay"+b, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Sorry !!!!!  Try again", Toast.LENGTH_SHORT).show();
        }

    }
}
