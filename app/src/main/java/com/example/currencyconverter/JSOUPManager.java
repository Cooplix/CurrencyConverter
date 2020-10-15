package com.example.currencyconverter;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSOUPManager {
    private Document document;
    private Thread secondThread;
    private Runnable runnable;


    public void init() { //method who init second thread
        //in main thread we can't download web-page
        runnable = new Runnable() {

            @Override
            public void run() {
                getWeb();
            }
        };

        //start second thread
        secondThread = new Thread(runnable);
        secondThread.start();
    }


    private void getWeb() { //get web page
        try {
            document = Jsoup.connect("https://internetowykantor.pl/kursy-walut/").get();

            Elements getTBody = document.getElementsByTag("tbody"); //get all tbody from page
            Element allCurrencyTBody = getTBody.get(0);
            Elements getElementsFromTable = allCurrencyTBody.children();

            Element euroElement = getElementsFromTable.get(0);
            Elements getEuroPurchase = euroElement.children();

            Element dollarElement = getElementsFromTable.get(1);
            Elements getDollarPurchase = dollarElement.children();

            Element swissFrancElement = getElementsFromTable.get(2);
            Elements getSwissFrancPurchase = swissFrancElement.children();

            Element poundSterlingElement = getElementsFromTable.get(3);
            Elements getPoundSterlingPurchase = poundSterlingElement.children();


            Log.d("MyLog", "Euro Purchase : " + getEuroPurchase.get(1).text());
            Log.d("MyLog", "USD Purchase : " + getDollarPurchase.get(1).text());
            Log.d("MyLog", "CHF Purchase : " + getSwissFrancPurchase.get(1).text());
            Log.d("MyLog", "GBP Purchase : " + getPoundSterlingPurchase.get(1).text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
