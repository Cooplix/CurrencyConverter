package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickConvert(View view) {
        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);

        Double amountDouble = Double.parseDouble(amountEditText.getText().toString());

        EditText resultAmountPolish = (EditText) findViewById(R.id.resultAmountPolish);

        convert(amountDouble);

        resultAmountPolish.setText(String.format("%.2f", amountDouble) + " PLN in Dollars: " + String.format("%.2f", convert(amountDouble)));

    }

    public Double convert(Double amountDouble) {
        return amountDouble * 3.5;
    }
}