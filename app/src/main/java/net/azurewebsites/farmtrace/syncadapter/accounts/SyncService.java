package net.azurewebsites.farmtrace.syncadapter.accounts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import net.azurewebsites.farmtrace.syncadapter.accounts.adapters.FarmTraceSyncAdapter;

/**
 * Created by sebichondo on 9/15/15.
 */
public class SyncService extends Service {
    private static final Object lock = new Object();
    private static FarmTraceSyncAdapter adapter = null;

    @Override
    public void onCreate() {
        synchronized (lock) {
            if (adapter == null) {
                // if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                //     adapter = new AfyaBandSyncAdapter(getApplicationContext(), true, true);
                // } else {
                adapter = new FarmTraceSyncAdapter(getApplicationContext(), true);
                //}
            }
        }
    }

    @Override
    public void onDestroy() {
        adapter.destroy();
        adapter = null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return adapter.getSyncAdapterBinder();
    }
}
