package com.example.tranlinh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner outSpinner,inSpinner;
    EditText  in_edit;
    TextView ret;
    Button exchangebtn, exitbtn;
    String inspin, outspin, inedit;
    DecimalFormat x = new DecimalFormat("#.####");
    float inCurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inSpinner = findViewById(R.id.in_spinner);
        outSpinner = findViewById(R.id.out_spinner);
        in_edit = findViewById(R.id.in_edtTxt);
        ret = findViewById(R.id.result);
        exchangebtn = findViewById(R.id.exchange_btn);
        exitbtn = findViewById(R.id.exit_btn);

        ArrayList<String> arrayInput = new ArrayList<>(3);
        arrayInput.add("VND");
        arrayInput.add("USD");
        arrayInput.add("EUR");

        ArrayAdapter arrayAdapterInput = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrayInput);
        inSpinner.setAdapter(arrayAdapterInput);

        ArrayList<String> arrayOutput = new ArrayList<>(3);
        arrayOutput.add("VND");
        arrayOutput.add("USD");
        arrayOutput.add("EUR");

        ArrayAdapter arrayAdapterOutput = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrayOutput);
        outSpinner.setAdapter(arrayAdapterOutput);

        inSpinner.setOnItemSelectedListener(this);
        outSpinner.setOnItemSelectedListener(this);

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


        exchangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inedit = in_edit.getEditableText().toString();
                inCurrent = Float.parseFloat(inedit.toString());HandleExchange(inspin, outspin, inCurrent);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner = (Spinner) adapterView;
        if(spinner.getId() == R.id.in_spinner){
            inspin = adapterView.getItemAtPosition(i).toString();
        }
        else if(spinner.getId() == R.id.out_spinner){
            outspin = adapterView.getItemAtPosition(i).toString();
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void HandleExchange(String in, String out, float inCurrent){

        /*========== VND ==========*/

        if(in == "VND" && out == "USD"){
            float result = inCurrent / 23000;
            String str = x.format(result);
            ret.setText(str);
        }
        if(in == "VND" && out == "EUR"){
            float result = inCurrent / 28000;
            String str = x.format(result);
            ret.setText(str);
        }

        if(in == "VND" && out == "VND"){
            String str = x.format(inCurrent);
            ret.setText(str);
        }


        /*========== USD ==========*/
        if(in == "USD" && out == "VND"){
            float result = inCurrent * 23000;
            String str = x.format(result);
            ret.setText(str);
        }
        if(in == "USD" && out == "EUR"){
            float result = inCurrent * 0.81f;
            String str = x.format(result);
            ret.setText(str);
        }
        if(in == "USD" && out == "USD"){
            String str = x.format(inCurrent);
            ret.setText(str);
        }

        /*========== EUR ==========*/

        if(in == "EUR" && out == "USD"){
            float result = inCurrent / 0.81f;
            String str = x.format(result);
            ret.setText(str);
        }
        if(in == "EUR" && out == "VND"){
            float result = inCurrent * 28000;
            String str = x.format(result);
            ret.setText(str);
        }
        if(in == "EUR" && out == "EUR"){
            String str = x.format(inCurrent);
            ret.setText(str);
        }


    }
}