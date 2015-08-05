package net.azurewebsites.farmtrace;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;


/**
 * Created by sebichondo on 8/4/15.
 */
public class MainThreadBus extends Bus implements Callback {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadBus.super.post(event);
                }
            });
        }
    }

    @Override
    public void success(Object o, Response response) {
        post(o);
        if(response != null) {
            for (Header header : response.getHeaders()) {
                if (header.getName().equals("X_SESSION")) {
                    XSessionTokenService.setSessionToken(header.getValue());
                }
            }
        }
    }

    @Override
    public void failure(RetrofitError error) {
        post(error);
    }
}
