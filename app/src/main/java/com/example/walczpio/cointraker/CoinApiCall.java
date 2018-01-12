package com.example.walczpio.cointraker;

import com.example.walczpio.cointraker.CoinData.CoinData;

import java.util.List;

import retrofit2.Call;

public class CoinApiCall {
    private final static String BASE_URL = "https://api.coinmarketcap.com/v1/ticker/";

    public Call<List<CoinData>> getCoinMarketData(String coin) {
        return CoinMarketCapAPI.client.getCoinMarketData(BASE_URL + coin);
    }
}
