package com.acrophillic.business;

import com.acrophillic.tourmate.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.GetChars;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class GridViewCustomAdapter extends ArrayAdapter<Object> { 
	
	 Context context;
	 TextView textViewTitle;
	 
	 
	public GridViewCustomAdapter(Context context, int resource) {
		super(context, 0);
		 this.context=context;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6;// no of item of GridView
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View row = convertView;
		  if (row == null) 
		  {
              LayoutInflater inflater = ((Activity) context).getLayoutInflater();
              row = inflater.inflate(R.layout.grid_row, parent, false);
              textViewTitle = (TextView) row.findViewById(R.id.textView1);
              ImageView imageViewIte = (ImageView) row.findViewById(R.id.imageView1);
              
             
              
              if(position  == 0)
              {            	            	  	
                      textViewTitle.setText("My Tour");
                      textViewTitle.setGravity(Gravity.CENTER);
                      imageViewIte.setImageResource(R.drawable.default_user);
              }
             else if(position  == 1)
              {
                      textViewTitle.setText("Police Station");
                      textViewTitle.setGravity(Gravity.CENTER);
                      imageViewIte.setImageResource(R.drawable.police_station);
              }
             else if(position  == 2)
              {
                      textViewTitle.setText("Coffee Cafe");
                      textViewTitle.setGravity(Gravity.CENTER);
                      imageViewIte.setImageResource(R.drawable.coffee);
              }
                else if(position  == 3)
              {
                      textViewTitle.setText("Hospital");
                      textViewTitle.setGravity(Gravity.CENTER);
                      imageViewIte.setImageResource(R.drawable.hospital);
              }
             else if(position  == 4)
              {
                      textViewTitle.setText("Shopping Mall");
                      textViewTitle.setGravity(Gravity.CENTER);
                      imageViewIte.setImageResource(R.drawable.shopping_mall);
              }
             else if(position  == 5)
              {
                      textViewTitle.setText("Hotel");
                      textViewTitle.setGravity(Gravity.CENTER);
                      imageViewIte.setImageResource(R.drawable.hotel);
              }
             

             
              
              
              
             
  } 
		return row;
	}

}
