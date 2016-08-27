package com.acrophillic.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.acrophillic.tourmate.R;

public class CreateTourActivity extends AppCompatActivity {


    EditText tvName;
    EditText tvStartDate;
    EditText tvEndDate;
    EditText tvStartPlace;
    EditText tvEndPlace;
    EditText tvBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);


         tvName =(EditText) findViewById(R.id.editTextEventName);
         tvStartDate =(EditText) findViewById(R.id.editTextStartDate);
         tvEndDate =(EditText) findViewById(R.id.editTextEndDate);
         tvStartPlace =(EditText) findViewById(R.id.editTextStartPlace);
         tvEndPlace =(EditText) findViewById(R.id.editTextVisitingPlace);
         tvBudget =(EditText) findViewById(R.id.editTextBudget);



    }


    public void CreateTour(View view){
        Log.e("test", "I am hree.....................");
    }
}
