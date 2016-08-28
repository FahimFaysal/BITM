package com.acrophillic.business;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.acrophillic.tourmate.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by fahim on 8/28/2016.
 */
public class MomentAdapter extends ArrayAdapter {

    private Moment moment;
    private ArrayList<Moment> momentsList;
    private Context context;
//     TextView tvNote;
//     ImageView imageView;


    public MomentAdapter(Context context, ArrayList<Moment> momentsList) {
        super(context, R.layout.row_moment, momentsList);
        this.context = context;
        this.momentsList = momentsList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        use to convert layout to view

        convertView = layoutInflater.inflate(R.layout.row_moment,null);

//        Text

        TextView tvNote = (TextView)convertView.findViewById(R.id.textViewNOte);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageViewPicture);

        Log.e("1111111111111", momentsList.get(position).getNote());
        tvNote.setText(momentsList.get(position).getNote());


        byte [] bytes = momentsList.get(position).getPicture();
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        imageView.setImageBitmap(bitmap);

        return convertView;
    }

}
