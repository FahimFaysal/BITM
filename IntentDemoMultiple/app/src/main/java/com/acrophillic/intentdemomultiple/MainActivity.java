package com.acrophillic.intentdemomultiple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
    }

    private void initialization() {
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);

    }

    public void usingArray(View view) {
        String string[] = {et1.getText().toString(), et2.getText().toString(), et3.getText().toString(), et4.getText().toString(), et5.getText().toString()};
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("array", string);
        startActivity(intent);
    }

    public void usingArrayList(View view) {

        ArrayList<String>arrayList = new ArrayList<>();

        arrayList.add(et1.getText().toString());
        arrayList.add(et2.getText().toString());
        arrayList.add(et3.getText().toString());
        arrayList.add(et4.getText().toString());
        arrayList.add(et5.getText().toString());

        Intent intent = new Intent(this, Activity3.class);

        intent.putStringArrayListExtra("arrayList", arrayList);



        startActivity(intent);
    }

    public void usingBundle(View view) {

        Bundle bundle = new Bundle();

        bundle.putString("first",et1.getText().toString());
        bundle.putString("second",et2.getText().toString());
        bundle.putString("third",et3.getText().toString());
        bundle.putString("forth",et4.getText().toString());
        bundle.putString("fifth",et5.getText().toString());

        Intent intent = new Intent(this, Activity4.class);

        intent.putExtra("bundle",bundle);

        startActivity(intent);
    }
}
