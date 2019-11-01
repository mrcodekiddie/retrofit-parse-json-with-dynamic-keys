package com.mrcodekiddie.pikaboo;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ServiceGenerator
{

    private static Integer timeOut=30;
    private static TimeUnit duration=TimeUnit.SECONDS;
    private static String baseURL="https://wission-9f1e1.firebaseio.com/";
    public static <S> S createService(Class<S> serviceClass)

    {
        OkHttpClient  httpClient=new OkHttpClient.Builder()
                .connectTimeout(timeOut,duration)
                .readTimeout(timeOut,duration )
                .writeTimeout(timeOut,duration)
                .cache(null)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(httpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return  retrofit.create(serviceClass);
    }
}