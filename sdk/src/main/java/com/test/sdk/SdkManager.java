package com.test.sdk;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 5/28/2017.
 */

public class SdkManager {
    private static Retrofit retrofit;

    private static SdkManager instance;

    private SdkManager() {

    }

    public synchronized static SdkManager getInstance() {

        if (instance == null) {
            instance = new SdkManager();
        }

        return instance;
    }

    public Retrofit getRetrofit(String url) {
        if (retrofit==null) {

            RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addCallAdapterFactory(rxAdapter)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
