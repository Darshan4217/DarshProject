package com.example.lenovo.myapplication.Retrofit;

import android.content.Context;
import android.util.Base64;
import com.example.lenovo.myapplication.base.ErrorHandlerInterceptor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RetrofitClientInstance {

    private OkHttpClient okHttpClient_login;

    private static Retrofit retrofit_login;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String AUTH = "Basic "+Base64.encodeToString(("darshan:123456").getBytes(), Base64.NO_WRAP);

    public RetrofitClientInstance(Context mContext) {
        //////This code is for login request only if request is except than login we will use new Retrofit instance and interceptor
        okHttpClient_login = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .addInterceptor(new ErrorHandlerInterceptor(mContext))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        Request request = originalRequest.newBuilder()
                                // .addHeader("Autherization", Credentials.basic("",""))
                                .addHeader("Autherization", AUTH)
                                .addHeader("content-type", "application/json")
                                .method(originalRequest.method(),originalRequest.body())
                                .build();

                        return chain.proceed(request);
                    }
                }).build();
    }

    public Retrofit getRetrofitInstanceLogin() {
        if (retrofit_login == null) {
            retrofit_login = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient_login)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit_login;
    }


    private static OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30,TimeUnit.SECONDS)
            .addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request request = originalRequest.newBuilder()
                    // .addHeader("Autherization", Credentials.basic("",""))
                    .addHeader("Token", "")
                    .method(originalRequest.method(),originalRequest.body())
                    .build();
            return chain.proceed(request);
        }
    }).build();

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
