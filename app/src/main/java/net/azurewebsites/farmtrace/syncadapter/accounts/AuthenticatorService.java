package net.azurewebsites.farmtrace.syncadapter.accounts;

import android.content.Intent;
import android.os.IBinder;
import android.app.Service;

/**
 * Created by sebichondo on 9/11/15.
 */
public class AuthenticatorService extends Service {
    private static final Object lock = new Object();
    private Authenticator auth;

    @Override
    public void onCreate() {
        synchronized (lock) {
            if (auth == null) {
                auth = new Authenticator(this);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return auth.getIBinder();
    }
}
