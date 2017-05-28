package com.test.sdk;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 5/28/2017.
 */

public class SdkManager {
    private static Retrofit retrofit;

    public Retrofit getRetrofit(Context context, String url) {
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
