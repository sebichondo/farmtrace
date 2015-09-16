package net.azurewebsites.farmtrace.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by sebichondo on 9/15/15.
 */
public class NetworkChangeReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = NetworkChangeReceiver.class.getSimpleName();
    private static boolean isConnected = false;
    private static NetworkChangeReceiver uniqInstance;
    private Context context;

    private NetworkChangeReceiver(Context context) {
        this.context = context;
        this.context = context;
    }

    public static synchronized NetworkChangeReceiver getInstance(Context context) {
        if (uniqInstance == null) {
            uniqInstance = new NetworkChangeReceiver(context);
        }
        return uniqInstance;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Log.v(LOG_TAG, "Receieved notification about network status");
        isNetworkAvailable(context);
    }


    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        if (!isConnected) {
                            Log.v(LOG_TAG, "Now you are connected to Internet!");
                            //networkStatus.setText("Now you are connected to Internet!");
                            isConnected = true;
                            //do your processing here ---
                            //if you need to post any data to the server or get status
                            //update from the server
                        }
                        return true;
                    }
                }
            }
        }
        Log.v(LOG_TAG, "You are not connected to Internet!");
        //networkStatus.setText("You are not connected to Internet!");
        isConnected = false;
        return false;
    }
}
