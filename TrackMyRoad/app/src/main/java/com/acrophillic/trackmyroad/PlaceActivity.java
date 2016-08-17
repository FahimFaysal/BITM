package com.acrophillic.trackmyroad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView)findViewById(R.id.textViewNoPlace);

        ArrayList<String> list = new ArrayList<>();

        ArrayList<GPS> GpsList;
        try {
            GpsList =  new FileReadWrite(this).readFromFile();

            Log.e("list0: ", GpsList.toString());

            for(int i = 0; i<GpsList.size()-1; i++){

                LatLng latLng=new LatLng(GpsList.get(i).getLatitude(),GpsList.get(i).getLongitude());
                list.add(GpsList.get(i).getLatitude()+", "+GpsList.get(i).getLongitude()+": "+GpsList.get(i).getLocationName());


            }


        }catch (java.lang.Exception e){
            e.printStackTrace();
        }


        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        if(list.isEmpty()){
          textView.setText("No place available ");
        }

     /*   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), arrayList.get(i), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }
        });*/



    }
}
