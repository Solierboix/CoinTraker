package com.example.walczpio.cointraker;

import com.example.walczpio.cointraker.CoinData.CoinData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface CoinMarketCapAPI {
    String BASE_URL = "https://api.coinmarketcap.com/v1/ticker/";
    @Headers("Content-Type: application/json")
    @GET
    Call<List<CoinData>> getCoinMarketData(@Url String url);
    Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
    CoinMarketCapAPI client = retrofit.create(CoinMarketCapAPI.class);
}
