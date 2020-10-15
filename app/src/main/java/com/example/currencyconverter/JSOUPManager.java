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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Elements getTBody() {
        return document.getElementsByTag("tbody"); //get all tbody from page
    }
}
