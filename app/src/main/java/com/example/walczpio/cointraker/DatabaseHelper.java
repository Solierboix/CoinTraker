package com.example.walczpio.cointraker;

import android.util.Log;
import android.widget.Toast;

import com.example.walczpio.cointraker.model.CryptoCoin;

import io.realm.Realm;

class DatabaseHelper {

    private final static String TAG = "DatabaseHelper";
    private final Realm realm = Realm.getDefaultInstance();

    void addResultsToRealmDB(final String id, final String name, final String symbol,
                             final String priceUSD, final String percentChange1h,
                             final String percentChange24h, final String percentChange7d){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CryptoCoin cryptoCoin = realm.createObject(CryptoCoin.class, id);
                cryptoCoin.setName(name);
                cryptoCoin.setSymbol(symbol);
                cryptoCoin.setPriceUSD(priceUSD);
                cryptoCoin.setPercentChange1h(percentChange1h);
                cryptoCoin.setPercentChange24h(percentChange24h);
                cryptoCoin.setPercentChange7d(percentChange7d);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v(TAG, "Data inserted");
                Toast.makeText(MyApplication.getAppContext(), "Data downloaded", Toast.LENGTH_LONG).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "onError: " + error.getMessage());
                Toast.makeText(MyApplication.getAppContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
