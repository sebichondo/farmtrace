package net.azurewebsites.farmtrace.event;

import android.os.Handler;
import android.os.Looper;

import net.azurewebsites.farmtrace.MainThreadBus;

/**
 * Created by sebichondo on 8/4/15.
 */
public class BusProvider {
    private static final MainThreadBus BUS = new MainThreadBus();

    public static MainThreadBus getInstance() {
        return BUS;
    }

    public static void postOnMainThread(final Object event) {
        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            public void run() {
                BUS.post(event);
            }
        });
    }

    private BusProvider() {
    }
}
