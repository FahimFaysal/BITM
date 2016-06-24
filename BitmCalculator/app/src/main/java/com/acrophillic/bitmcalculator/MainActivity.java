package com.acrophillic.bitmcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et;

    private TextView tv;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnMultiple;
    Button btnMinus;
    Button btnPlus;
    Button btnPonitDevided;
    Button btnEqual;
    Button btnCancel;
    Button btnPoint;

    private ProcessManager processManager = new ProcessManager();

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
                tv.setText("");
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
                    st = processManager.process(st);
                }
                tv.setText(st);
                break;
        }
    }
}
