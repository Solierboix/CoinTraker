package com.example.walczpio.cointraker;

import com.example.walczpio.cointraker.CoinData.CoinData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataDownloadFromCoinApi {

    private DatabaseHelper mDatabaseHelper = new DatabaseHelper();


    public void getDataFromJson(String coin){
        CoinApiCall apiCall = new CoinApiCall();
        apiCall.getCoinMarketData(coin).enqueue(new Callback<List<CoinData>>() {
            @Override
            public void onResponse(Call<List<CoinData>> call, Response<List<CoinData>> response) {
                String id = response.body().get(0).getId();
                String name = response.body().get(0).getName();
                String symbol = response.body().get(0).getSymbol();
                String priceUSD = response.body().get(0).getPriceUsd();
                String percentChange1h = response.body().get(0).getPercentChange1h();
                String percentChange24h = response.body().get(0).getPercentChange24h();
                String percentChange7d = response.body().get(0).getPercentChange7d();

                mDatabaseHelper.addResultsToRealmDB(id, name, symbol, priceUSD, percentChange1h, percentChange24h, percentChange7d);

            }
            @Override
            public void onFailure(Call<List<CoinData>> call, Throwable t) {

            }
        });

    }
}
