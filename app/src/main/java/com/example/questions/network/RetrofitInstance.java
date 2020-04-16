package com.example.questions.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.questions.network.Constants.BASE_URL;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static RetrofitInterface getClient(){
        if (retrofit == null){
            retrofit =  new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitInterface.class);
    }
}
