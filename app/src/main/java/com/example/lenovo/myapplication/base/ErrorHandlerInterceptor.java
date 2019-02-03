package com.example.lenovo.myapplication.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class ErrorHandlerInterceptor implements Interceptor {

    private Context mContext;
    private static String NO_CONNECTION_ERROR_TYPE = "noConnectionErrorType";
    private static String NO_CONNECTION_ERROR_CODE = "noConnectionErrorCode";

    public ErrorHandlerInterceptor(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Response response = null;

        if (isConnected())
            response = chain.proceed(chain.request());
        else {
            try {
                throw new CustomException(NO_CONNECTION_ERROR_TYPE, NO_CONNECTION_ERROR_CODE);
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
        return response;
    }


    private Boolean isConnected() {
        if (mContext != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

}
