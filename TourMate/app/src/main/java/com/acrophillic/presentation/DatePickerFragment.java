package com.acrophillic.presentation;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public DatePickerFragment(){}


    EditText editTextBirthDate;
    @SuppressLint("ValidFragment")
    public  DatePickerFragment(View view){
        editTextBirthDate=(EditText) view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

      //  super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_registration);

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public  void onDateSet(DatePicker view,int year,int month,int day){
        String date=day+"-"+(month+1)+"-"+year;
        editTextBirthDate.setText(date);
    }


}
