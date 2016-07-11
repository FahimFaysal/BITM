package com.acrophillic.dbcustomadpterhw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fahim on 7/11/2016.
 */
public class CustomAdapter extends ArrayAdapter {


    private TextView tvName;
    private TextView tvGroup;
    private TextView tvEmail;
    private TextView tvMoible;

    private ContactTO contactTO;
    private ArrayList<ContactTO> contactList;
    private Context context;

    public CustomAdapter(Context context, ArrayList<ContactTO> contactList) {
        super(context, R.layout.list_row,contactList);
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        use to convert layout to view

        convertView = layoutInflater.inflate(R.layout.list_row,null);

        tvName = (TextView)convertView.findViewById(R.id.textViewName);
        tvGroup = (TextView)convertView.findViewById(R.id.textViewGroup);
        tvEmail = (TextView)convertView.findViewById(R.id.textViewEmail);
        tvMoible = (TextView)convertView.findViewById(R.id.textViewMobile);

        tvName.setText/*("asdfas");//*/(contactList.get(position).getName());
        tvGroup.setText/*("asdfas");//*/(contactList.get(position).getGroupName());
        tvEmail.setText/*("asdfas");//*/(contactList.get(position).getEmailId());
        tvMoible.setText/*("asdfas");//*/(contactList.get(position).getPhoneNo());


        return convertView;
    }
}
