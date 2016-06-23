package com.acrophillic.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomRow extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_row);


        listView = (ListView) findViewById(R.id.listCustomRaw);

        final List<Poet> poetList = new ArrayList<>();

        Poet poet = new Poet("kazi nazrul islam", "Kazi Nazrul Islam was a Bangladeshi poet, writer, musician, and revolutionary, and is the national poet of Bangladesh");
        poetList.add(poet);

        Poet poet1 = new Poet("Rabindranath tagore", "Rabindranath Tagore FRAS, also written Ravīndranātha Thākura, sobriquet Gurudev, was a Bengali polymath who reshaped Bengali literature and music, as well as Indian art with Contextual Modernism in the late 19th and early 20th centuries");
        poetList.add(poet1);

        Poet poet2 = new Poet("sukanto vortacharjo", "Sukanta Bhattacharya was a Bengali poet and playwright. Along with Rabindranath Tagore and Kazi Nazrul Islam, he was one of the key figures of modern Bengali poetry, despite the fact that most of his works had been in publication posthumously.");
        poetList.add(poet2);

        Poet poet3 = new Poet("Sarat Chandra Chattopadhyay", "Sarat Chandra Chattopadhyay, alternatively spelt as Sarat Chandra Chatterjee, was a Bengali novelist and short story writer of early 20th century. Most of his works deal with the lifestyle and tragedy of the lower caste people");
        poetList.add(poet3);


        final ArrayList<String> nameList = new ArrayList<>();


      /*  Iterator<Poet> iterator = poetList.iterator();
        while (poetList.hasNext()) {
//            nameList.add()
//            nameList.add(iterator.next());
        }*/

        for (Poet temp : poetList) {
            nameList.add(temp.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.row, R.id.textView, nameList);
        // only one view applicable ;)
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              /*  Toast.makeText(getApplicationContext(), poetList.get(i), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();*/

                Intent intent = new Intent(getApplicationContext(), PoetActivity.class);
                intent.putExtra("poet",poetList.get(i)); // poet TO is Serializable
                startActivity(intent);

            }
        });
    }
}
