package com.example.currencyconverter;

import android.util.Log;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetTheCurrentExchangeRate {
    private Double _EUR;
    private Double _USD;
    private Double _CHF;
    private Double _GBP;


    public void getCurrency(Elements elements) {
        Element allCurrencyTBody = elements.get(0);
        Elements getElementsFromTable = allCurrencyTBody.children();

        Element euroElement = getElementsFromTable.get(0);
        Elements getEuroPurchase = euroElement.children();

        Element dollarElement = getElementsFromTable.get(1);
        Elements getDollarPurchase = dollarElement.children();

        Element swissFrancElement = getElementsFromTable.get(2);
        Elements getSwissFrancPurchase = swissFrancElement.children();

        Element poundSterlingElement = getElementsFromTable.get(3);
        Elements getPoundSterlingPurchase = poundSterlingElement.children();


        Log.d("MyLog", "Euro Purchase : " + replace(getEuroPurchase.get(1).text(), 1, '.'));
        Log.d("MyLog", "USD Purchase : " + replace(getDollarPurchase.get(1).text(), 1, '.'));
        Log.d("MyLog", "CHF Purchase : " + replace(getSwissFrancPurchase.get(1).text(), 1, '.'));
        Log.d("MyLog", "GBP Purchase : " + replace(getPoundSterlingPurchase.get(1).text(), 1, '.'));

        set_EUR(Double.parseDouble((replace(getEuroPurchase.get(1).text(), 1, '.'))));  //change "," to "."
        set_USD(Double.parseDouble((replace(getDollarPurchase.get(1).text(), 1, '.')))); //change "," to "."
        set_CHF(Double.parseDouble((replace(getSwissFrancPurchase.get(1).text(), 1, '.'))));  //change "," to "."
        set_GBP(Double.parseDouble((replace(getPoundSterlingPurchase.get(1).text(), 1, '.')))); //change "," to "."

        Double x = get_USD();
        Log.d("Type: ", x.getClass().getName());
        Log.d("USD", String.valueOf(get_USD()));

    }


    public Double get_EUR() {
        return _EUR;
    }

    public void set_EUR(Double _EUR) {
        this._EUR = _EUR;
    }

    public Double get_USD() {
        return _USD;
    }

    public void set_USD(Double _USD) {
        this._USD = _USD;
    }

    public Double get_CHF() {
        return _CHF;
    }

    public void set_CHF(Double _CHF) {
        this._CHF = _CHF;
    }

    public Double get_GBP() {
        return _GBP;
    }

    public void set_GBP(Double _GBP) {
        this._GBP = _GBP;
    }



    public String replace(String str, int index, char replace){
        if(str==null){
            return str;
        }else if(index<0 || index>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }
}
