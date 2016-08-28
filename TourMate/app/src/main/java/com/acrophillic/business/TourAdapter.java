package com.acrophillic.business;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.acrophillic.tourmate.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by fahim on 7/24/2016.
 */
public class TourAdapter extends ArrayAdapter {


    private TextView tvEventName;
    private TextView tvPlace;
    private TextView tvDate;
    private TextView tvBudget;


    private Tour tour;
    private ArrayList<Tour> tourList;
    private Context context;


    public TourAdapter(Context context, ArrayList<Tour> tourList) {
        super(context, R.layout.row_tour, tourList);
        this.context = context;
        this.tourList = tourList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        use to convert layout to view

        convertView = layoutInflater.inflate(R.layout.row_tour,null);

        tvEventName = (TextView)convertView.findViewById(R.id.textViewEventName);
        tvPlace = (TextView)convertView.findViewById(R.id.textViewPlace);
        tvDate = (TextView)convertView.findViewById(R.id.textViewDate);
        tvBudget = (TextView)convertView.findViewById(R.id.textViewBudget);

        tvEventName.setText(tourList.get(position).getTourName());
        tvPlace.setText(tourList.get(position).getToPlace()+" to "+tourList.get(position).getFromPlace());
//        tvDate.setText(tourList.get(position).getStartDate()+"");

        tvDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(tourList.get(position).getStartDate().getTime()).toString()+" to "+new SimpleDateFormat("dd/MM/yyyy").format(tourList.get(position).getEndDate().getTime()).toString());
//        tvDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(user.getDOB().getTime()).toString());
        tvBudget.setText(tourList.get(position).getBudget()+"");


        return convertView;
    }


}
