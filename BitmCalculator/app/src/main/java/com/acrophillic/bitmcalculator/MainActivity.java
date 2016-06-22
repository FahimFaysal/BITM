package com.acrophillic.bitmcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et;
    TextView tv;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnMultiple, btnMinus, btnPlus, btnPonitDevided, btnEqual, btnCancel, btnPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editText);

        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnPonitDevided = (Button) findViewById(R.id.buttonDivid);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMultiple = (Button) findViewById(R.id.buttonMultiple);
        btnCancel = (Button) findViewById(R.id.buttonCancel);
        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btnPoint = (Button) findViewById(R.id.buttonPoint);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPonitDevided.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMultiple.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnPoint.setOnClickListener(this);

        btnCancel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                et.setText("");
                return true;
            }
        });

    }


    public void onClick(View v) {
        String st = "";
        switch (v.getId()) {
            case R.id.button0:

                st = et.getText().toString();
                String string = null;
                if (!st.isEmpty() && st.charAt(st.length() - 1) == '0') {
                    StringTokenizer str = new StringTokenizer(st, "+,x,-,/");
                    while (str.hasMoreElements()) {
                        Object obj1 = str.nextElement();
                        string = (String) obj1;

                    }
                    if (!string.equals("0")) {
                        st += 0;
                        et.setText(st);
                    }
                } else {
                    st += 0;
                    et.setText(st);
                }

//                Toast.makeText(MainActivity.this, "1...............", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button1:
                st = et.getText().toString();
                st += 1;
                et.setText(st);
                break;

            case R.id.button2:
                st = et.getText().toString();
                st += 2;
                et.setText(st);
                break;
            case R.id.button3:
                st = et.getText().toString();
                st += 3;
                et.setText(st);
                break;
            case R.id.button4:
                st = et.getText().toString();
                st += 4;
                et.setText(st);
                break;
            case R.id.button5:
                st = et.getText().toString();
                st += 5;
                et.setText(st);
                break;
            case R.id.button6:
                st = et.getText().toString();
                st += 6;
                et.setText(st);
                break;
            case R.id.button7:
                st = et.getText().toString();
                st += 7;
                et.setText(st);
                break;
            case R.id.button8:
                st = et.getText().toString();
                st += 8;
                et.setText(st);
                break;
            case R.id.button9:
                st = et.getText().toString();
                st += 9;
                et.setText(st);
                break;
            case R.id.buttonPlus:
                st = et.getText().toString();
                if (!st.isEmpty()) {
                    if (st.charAt(st.length() - 1) == '.' || st.charAt(st.length() - 1) == '+' || st.charAt(st.length() - 1) == 'x' || st.charAt(st.length() - 1) == '-' || st.charAt(st.length() - 1) == '/') {
                        st = st.substring(0, st.length() - 1) + '+';
                        et.setText(st);

                    } else {
                        st += '+';
                        et.setText(st);
                    }
                } else {
                    st += '+';
                    et.setText(st);
                }
                break;
            case R.id.buttonMinus:
                st = et.getText().toString();
                if (!st.isEmpty()) {
                    if (st.charAt(st.length() - 1) == '.' || st.charAt(st.length() - 1) == '+' || st.charAt(st.length() - 1) == 'x' || st.charAt(st.length() - 1) == '-' || st.charAt(st.length() - 1) == '/') {
                        st = st.substring(0, st.length() - 1) + '-';
                        et.setText(st);

                    } else {
                        st += '-';
                        et.setText(st);
                    }
                } else {
                    st += '-';
                    et.setText(st);
                }


                break;
            case R.id.buttonMultiple:

                st = et.getText().toString();
                if (!st.isEmpty()) {
                    if (st.charAt(st.length() - 1) == '.' || st.charAt(st.length() - 1) == '+' || st.charAt(st.length() - 1) == 'x' || st.charAt(st.length() - 1) == '-' || st.charAt(st.length() - 1) == '/') {
                        st = st.substring(0, st.length() - 1) + 'x';
                        et.setText(st);

                    } else {
                        st += 'x';
                        et.setText(st);
                    }
                }
                break;

            case R.id.buttonDivid:
                st = et.getText().toString();
                if (!st.isEmpty()) {
                    if (st.charAt(st.length() - 1) == '.' || st.charAt(st.length() - 1) == '+' || st.charAt(st.length() - 1) == 'x' || st.charAt(st.length() - 1) == '-' || st.charAt(st.length() - 1) == '/') {
                        st = st.substring(0, st.length() - 1) + '/';
                        et.setText(st);

                    } else {
                        st += '/';
                        et.setText(st);
                    }
                }

                break;
            case R.id.buttonCancel:
                st = et.getText().toString();
//                Log.d("Cancel............", st);
                if (st.length() != 0) {
                    st = st.substring(0, st.length() - 1);
                    et.setText(st);
                }

                break;


            case R.id.buttonPoint:
                st = et.getText().toString();
                string = null;
                if (!st.isEmpty()) {
                    StringTokenizer str = new StringTokenizer(st, "+,x,-,/");
                    while (str.hasMoreElements()) {
                        Object obj1 = str.nextElement();
                        string = (String) obj1;
//                        Log.d("part", string);
                    }
                    if (string.isEmpty() || !string.contains(".")) {
                        st += ".";
                        et.setText(st);
                    } else if (st.charAt(st.length() - 1) == 'x' || st.charAt(st.length() - 1) == '/' || st.charAt(st.length() - 1) == '+' || st.charAt(st.length() - 1) == '-') {
                        st += ".";
                        et.setText(st);

                    }
                } else {
                    et.setText(".");
                }


                break;
            case R.id.buttonEqual:
                st = et.getText().toString();
                if (st.length() != 0) {
                    st = calculate(st);
                }
                tv.setText(st);
                break;
        }
    }

    private String calculate(String mainEquation) {
        try {
            if (mainEquation.charAt(0) == 'x' || mainEquation.charAt(0) == '/') {
                return "wrong equation";
            } else if (!Character.isDigit(mainEquation.charAt(mainEquation.length() - 1)) && mainEquation.charAt(mainEquation.length() - 1) != '.') {

                return "wrong equation";
            }/* else {
            for (int i = 0; i < mainEquation.length() - 1; i++) {
                if (!Character.isDigit(mainEquation.charAt(i)) && !Character.isDigit(mainEquation.charAt(i + 1))) {
                    return "wrong equation3";
                }
            }

        }*/
            // ================================== X =====================================
            for (int i = 0; i < mainEquation.length(); i++) { // x
                if (mainEquation.charAt(i) == 'x') {
                    String s1 = "", s2 = "";
                    int p, n;

                    for (p = i - 1; p >= 0; p--) {

                        if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                            break;
                        }
                    }
                    p++;
                    s1 = mainEquation.substring(p, i);
                    System.out.println(s1 + "-----------------------------s1");

                    for (n = i + 1; n < mainEquation.length(); n++) {// *********************************************
                        if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {
                            break;
                        }

                    }

                    s2 = mainEquation.substring(i + 1, n);
                    System.out.println(s2 + "______________________________s2");

                    if (s1.isEmpty() || s2.isEmpty()) {
                        continue;
                    }

                    Double res = Double.parseDouble(s1) * Double.parseDouble(s2);
                    System.out.println("res " + res);
                    s1 = "";
                    s1 += res;

                    System.out.println("s1************" + s1);

                    s2 = mainEquation.substring(0, p);
                    System.out.println("s2************" + s2);

                    mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                    System.out.println("************" + mainEquation);
                    i = p - 1;
                }
            }
            // ===============================/================================
            for (int i = 0; i < mainEquation.length(); i++)

            {
                if (mainEquation.charAt(i) == '/') {
                    String s1 = "", s2 = "";
                    int p, n;

                    for (p = i - 1; p >= 0; p--) {

                        if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                            break;
                        }
                    }
                    p++;
                    s1 = mainEquation.substring(p, i);
                    System.out.println(s1 + "-----------------------------s1");

                    for (n = i + 1; n < mainEquation.length(); n++) {
                        if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {

                            break;
                        }
                        // System.out.println(mainEquation.charAt(n));
                    }

                    s2 = mainEquation.substring(i + 1, n);
                    System.out.println(s2 + "______________________________s2");

                    if (s1.isEmpty() || s2.isEmpty()) {
                        continue;
                    }
                    Double res = Double.parseDouble(s1) / Double.parseDouble(s2);
                    System.out.println("res " + res);
                    s1 = "";
                    s1 += res;

                    System.out.println("s1************" + s1);

                    s2 = mainEquation.substring(0, p);
                    System.out.println("s2************" + s2);

                    mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                    System.out.println("************" + mainEquation);
                    i = p - 1;
                }
            }
            // ==================================+=========================
            for (int i = 0; i < mainEquation.length(); i++)

            {

                if (mainEquation.charAt(i) == '+' && i != 0) {

                    String s1 = "", s2 = "";
                    int p, n;

                    for (p = i - 1; p >= 0; p--) {

                        if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                            break;
                        }
                    }

                    p++;
                    if (p != 0 && (mainEquation.charAt(p - 1) == '-' || mainEquation.charAt(p - 1) == '+')) {
                        p--;
                    }
                    s1 = mainEquation.substring(p, i);
                    System.out.println(s1 + "-----------------------------s1");

                    for (n = i + 1; n < mainEquation.length(); n++) {
                        if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {
                            break;
                        }
                    }

                    s2 = mainEquation.substring(i + 1, n);
                    System.out.println(s2 + "______________________________s2");

                    if (s1.isEmpty() || s2.isEmpty()) {
                        continue;
                    }
                    Double res = Double.parseDouble(s1) + Double.parseDouble(s2);

                    if (res > 0) {
                        s1 = "+";
                        s1 += res;
                    } else {
                        s1 = "";
                        s1 += res;
                    }

                    System.out.println("res " + res);

                    System.out.println("s1************" + s1);

                    s2 = mainEquation.substring(0, p);
                    System.out.println("s2************" + s2);

                    i = p - 1;


                    mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                    System.out.println("************" + mainEquation);

                }

            }
            // =============================== - ====================
            for (int i = 0; i < mainEquation.length(); i++)

            {
                if (mainEquation.charAt(i) == '-' && i != 0) {
                    String s1 = "", s2 = "";
                    int p, n;

                    for (p = i - 1; p >= 0; p--) {

                        if (!Character.isDigit(mainEquation.charAt(p)) && mainEquation.charAt(p) != '.') {
                            break;
                        }
                    }
                    p++;
                    if (p != 0 && (mainEquation.charAt(p - 1) == '-' || mainEquation.charAt(p - 1) == '+')) {
                        p--;
                    }
                    s1 = mainEquation.substring(p, i);
                    System.out.println(s1 + "-----------------------------s1");

                    for (n = i + 1; n < mainEquation.length(); n++) {
                        if (!Character.isDigit(mainEquation.charAt(n)) && mainEquation.charAt(n) != '.') {
                            break;
                        }
                    }

                    s2 = mainEquation.substring(i + 1, n);
                    System.out.println(s2 + "______________________________s2");

                    if (s1.isEmpty() || s2.isEmpty()) {
                        continue;
                    }
                    Double res = Double.parseDouble(s1) - Double.parseDouble(s2);

                    if (res > 0) {
                        s1 = "+";
                        s1 += res;
                    } else {
                        s1 = "";
                        s1 += res;
                    }

                    System.out.println("res " + res);
                    System.out.println("s1************" + s1);

                    s2 = mainEquation.substring(0, p);
                    System.out.println("s2************" + s2);

                    mainEquation = s2 + s1 + mainEquation.substring(n, mainEquation.length());

                    System.out.println("************" + mainEquation);
                    i = p - 1;
                }
            }
        } catch (Exception e) {
            if (e.getMessage().equalsIgnoreCase("Infinity")) {
                return "x/0 ! does not make any sense";
            } else {
                return "Not a equation";
            }
        }
//====================================finalize===========================
        Log.d("final raw value", mainEquation);
        /*if (mainEquation.substring(mainEquation.length() - 2, mainEquation.length()).equals(".0")) {
            mainEquation = mainEquation.substring(0, mainEquation.length() - 2);
        }*/

//        if(mainEquation.contains(".")){

        while (mainEquation.contains(".")) {

            if(mainEquation.equals(".")){
                mainEquation = "";
                break;
            }else if (mainEquation.charAt(mainEquation.length() - 1) == '0') {
                mainEquation = mainEquation.substring(0, mainEquation.length() - 2);

            } else if (mainEquation.charAt(mainEquation.length() - 1) == '.') {
                System.out.println("i am here................");
                mainEquation.replace(".", "");
                break;
            } else {
                break;
            }
        }


//        }


        if (!mainEquation.isEmpty() && mainEquation.charAt(0) == '+') {
            mainEquation = mainEquation.substring(1, mainEquation.length());
        }

        if (mainEquation.equalsIgnoreCase("Infinity")) {
            return "x/0 ! does not make sense";
        }

        Log.d("final raw return", mainEquation);
        return mainEquation;
    }
}
