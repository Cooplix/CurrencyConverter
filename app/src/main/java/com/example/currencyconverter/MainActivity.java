package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    JSOUPManager jsoupManager = new JSOUPManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsoupManager.init();

    }

    public void onClickConvert(View view) {
        GetTheCurrentExchangeRate getTheCurrentExchangeRate = new GetTheCurrentExchangeRate();
        getTheCurrentExchangeRate.getCurrency(jsoupManager.getTBody());

        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);

        Double amountDouble = Double.parseDouble(amountEditText.getText().toString());

        EditText resultAmountPolish = (EditText) findViewById(R.id.resultAmountPolish);

        resultAmountPolish.setText(new StringBuilder()
                .append(String.format("%.2f", amountDouble))
                .append(" USD in PLN: ")
                .append(convert(amountDouble, getTheCurrentExchangeRate.get_USD()).toString()));

    }

    public Double convert(Double amountDouble, Double currentRate) {
        return amountDouble * currentRate;
    }
}