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

    public void convert(View view) {
        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);

        Double amountDouble = Double.parseDouble(amountEditText.getText().toString());

        Double polishAmount = amountDouble * 3.5;

        Toast.makeText(MainActivity.this, polishAmount.toString() + " in Dollars: " + polishAmount.toString(), LENGTH_SHORT).show();
;    }
}