package net.azurewebsites.api;

import android.util.Log;

import com.squareup.otto.Bus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sebichondo on 8/13/15.
 */
public abstract class RestCallback<T> implements Callback<T> {
    private String tag = this.getClass().getCanonicalName();

    private Bus bus;
    private long requestId;

    public RestCallback(T t, Bus bus, long requestId) {
        this.bus = bus;
        this.requestId = requestId;
        tag = t.getClass().getCanonicalName();
    }

    public RestCallback(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void success(T t, Response response) {
        Log.d(tag, "ON SUCCESS ");
        try {
            //the app crashes when the response processing fails downstream
            if (t != null) {
                bus.post(t);
                Log.d(tag, fromStream(response));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String fromStream(Response response) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
            StringBuilder out = new StringBuilder();
            String newLine = System.getProperty("line.separator");
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append(newLine);
            }
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void failure(RetrofitError error) {

        try {
            String errorMessage = error.getResponse().getReason();
            bus.post(new RetrofitErrorEvent(requestId, error, errorMessage));
            tag = error.getSuccessType().toString();
            Log.d(tag, "request id: " + requestId + " RetrofitErrorEvent: " + error.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}