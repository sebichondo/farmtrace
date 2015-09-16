package net.azurewebsites.farmtrace.syncadapter.accounts.adapters;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SyncResult;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.OperationCanceledException;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import net.azurewebsites.api.plantingactivity.IPlantingActivityService;
import net.azurewebsites.api.plantingactivity.PlantingActivityResponse;
import net.azurewebsites.api.usn.IUSNService;
import net.azurewebsites.farmtrace.Constants;
import net.azurewebsites.farmtrace.DaggerMainComponent;
import net.azurewebsites.farmtrace.FarmTraceApp;
import net.azurewebsites.farmtrace.FarmerServiceModule;
import net.azurewebsites.farmtrace.HasComponent;
import net.azurewebsites.farmtrace.MainComponent;
import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingActivity;
import net.azurewebsites.farmtrace.datamodel.dao.UpdateSequenceNumbers;
import net.azurewebsites.farmtrace.datamodel.dao.User;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.event.BusProvider;
import net.azurewebsites.farmtrace.syncadapter.accounts.Authenticator;
import net.azurewebsites.farmtrace.utils.Settings;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by sebichondo on 9/11/15.
 */
public class FarmTraceSyncAdapter extends AbstractThreadedSyncAdapter implements HasComponent<MainComponent> {
    private final ContentResolver mContentResolver;
    private final AccountManager mAccountManager;
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    //private static long lastsynctime = 0;
    private static final String TAG = FarmTraceSyncAdapter.class.getSimpleName();
    private User cu;
    private boolean mShowNotifications = true;
    // private boolean isConnected = false;
    private boolean isWifiConnected = false;
    private boolean isMobileConnected = false;
    private NetworkChangeReceiver receiver;

    private MainComponent mainComponent;

    @Inject
    IPlantingActivityService plantingActivityService;

    @Inject
    IUSNService usnService;
    protected Bus bus = BusProvider.getInstance();


    public FarmTraceSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
        mAccountManager = AccountManager.get(context);
        Settings.createInstance(context);
        //service= FieldWorkApplication.getInstance().getService();
        mShowNotifications = Settings.getSyncShowNotifications();
        cu = Settings.getCurrentUser();
        startNetworkMonitoring(context);
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.cloud_sync);
        mBuilder = new NotificationCompat.Builder(context)
                .setContentText(context.getString(R.string.sync_title))
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.mipmap.black_hand_planting);

        FarmTraceApp app = FarmTraceApp.get(getContext());

        mainComponent = DaggerMainComponent.builder()
                .appComponent(app.component())
                .farmerServiceModule(new FarmerServiceModule())
                .build();
        mainComponent.inject(this);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public FarmTraceSyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        Settings.createInstance(context);
        mContentResolver = context.getContentResolver();
        mAccountManager = AccountManager.get(context);
        mShowNotifications = Settings.getSyncShowNotifications();


        cu = Settings.getCurrentUser();
        startNetworkMonitoring(context);
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.cloud_sync);
        mBuilder = new NotificationCompat.Builder(context)
                .setContentText(context.getString(R.string.sync_title))
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.mipmap.black_hand_planting);

    }

    private void startNetworkMonitoring(Context context) {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
        context.registerReceiver(receiver, filter);
        bus.register(this);
        Log.d(Constants.LOG_TAG, TAG + "> Bus REGISTER");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onPerformSync(Account account, Bundle extras, String sd, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        mShowNotifications = Settings.getSyncShowNotifications();
        // Building a print of the extras we got
        StringBuilder sb = new StringBuilder();
        if (extras != null) {
            for (String key : extras.keySet()) {
                sb.append(key + "[" + extras.get(key) + "] ");
            }
        }

        Log.d(Constants.LOG_TAG, TAG + "> onPerformSync for account[" + account.name + "]. Extras: " + sb.toString());
        String authToken = null;
        try {
            authToken = mAccountManager.blockingGetAuthToken(account, Authenticator.AUTHTOKEN_TYPE, true);

            Log.d(Constants.LOG_TAG, TAG + "> blockingGetAuthToken token " + authToken);

            //clear former errors
            mNotificationManager.cancel(Constants.ID_SYNC_ERROR);
            setNotificationProgress("preparing to sync with cloud", 0, 0, true);

            //sync
            syncPlantingActivities(syncResult);

            doduedilligence();

            mNotificationManager.cancel(Constants.ID_SYNC);
        } catch (OperationCanceledException e) {
            showError("sync error", e.getMessage());
            Log.e(Constants.LOG_TAG, TAG + "> onPerformSync " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            showError("sync error", e.getMessage());
            Log.e(Constants.LOG_TAG, TAG + "> onPerformSync " + e.getMessage());
            e.printStackTrace();
        } catch (AuthenticatorException e) {
            showError("sync error", e.getMessage());
            Log.e(Constants.LOG_TAG, TAG + "> onPerformSync " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            showError("sync error", e.getMessage());
            Log.e(Constants.LOG_TAG, TAG + "> onPerformSync " + e.getMessage());
            e.printStackTrace();
        } finally {


        }
    }

    private void doduedilligence() {
        //methods that must run to ensure everything is OK
        Settings.setHasPendingSync(false);
        //update sync times of users to populate else where

        //getContext().getContentResolver().notifyChange(AfyaBandContentProvider.CONTENT_URI,null,false);
    }


    private void syncPlantingActivities(SyncResult syncResult) {
        //all the magic happens here
        try {
            setNotificationProgress("Syncing Zone data", 0, 0, true);
            //TEST POSTING HERE
            Long usnID = DataRepository.getMaxUSN(getContext());

            Log.d("DataRepository", "The USDN ID: " + usnID);
            List<PlantingActivity> plantingActivities = DataRepository.getAllPlantingActivitiesByUSNID(getContext(), usnID);
            for (net.azurewebsites.farmtrace.datamodel.dao.PlantingActivity plantingActivity : plantingActivities) {
                plantingActivityService.savePlantingActivities(plantingActivity.getPlantingActivityID(),
                        plantingActivity.getActivityType(), plantingActivity.getInput(), plantingActivity.getQuantity(), plantingActivity.getLocation(),
                        plantingActivity.getActivityDate(), plantingActivity.getUserID(), plantingActivity.getFieldID(), plantingActivity.getUsnID(), bus);
            }

            Log.d("DataRepository", "The SIZE OF THE Planting Activities: " + plantingActivities.size());

            usnService.saveUSNs(null, new Date(), Settings.getCurrentUser().getUserID(),usnID, bus);

            Date date = new Date();
            UpdateSequenceNumbers usn = new UpdateSequenceNumbers(null, date, Settings.getCurrentUser().getUserID());
            DataRepository.insertOrUpdateUSNs(getContext(), usn);
        } catch (Exception e) {
            showError("user details sync error", e.getMessage());
            Log.e(Constants.LOG_TAG, TAG + "> syncPlantingActivities > Error parsing feed: " + e.toString());
            syncResult.stats.numParseExceptions++;
            return;
        }

        Log.d(Constants.LOG_TAG, TAG + "> syncPlanting Activities > DONE");

    }

    @Subscribe
    public void onFetchPlantingActivitiesResponse(PlantingActivityResponse plantingActivityResponse) {
        Log.d(Constants.LOG_TAG, TAG + "> Ensure that we get RESPONSE before updating the Sequence Number");

    }

    public void destroy() {
        try {
            getContext().unregisterReceiver(receiver);
            bus.unregister(this);
            Log.d(Constants.LOG_TAG, TAG + "> Bus UNREGISTER");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MainComponent getComponent() {
        return null;
    }

    private class NetworkChangeReceiver extends BroadcastReceiver {
        private final String LOG_TAG = NetworkChangeReceiver.class.getSimpleName();

        @Override
        public void onReceive(final Context context, final Intent intent) {
            Log.v(LOG_TAG, "Receieved notification about network status");
            isNetworkAvailable(context);
        }


        private void isNetworkAvailable(Context context) {
            ConnectivityManager connectivity = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            boolean hasChanged = false;
            if (connectivity != null) {
                //wifi
                NetworkInfo networkInfo = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (networkInfo != null) {
                    isWifiConnected = networkInfo.isConnected();
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        if (!isWifiConnected) {
                            hasChanged = true;
                            isWifiConnected = true;
                        }
                    }
                }

                //mobile
                networkInfo = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if (networkInfo != null) {
                    isMobileConnected = networkInfo.isConnected();
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        if (!isMobileConnected) {
                            hasChanged = true;
                            isMobileConnected = true;
                        }
                    }
                }

                if (isMobileConnected || isWifiConnected) {
                    if (hasChanged) {
                        Log.v(LOG_TAG, "Now you are connected to Internet!");
                        Settings.createInstance(context);
                        if (Settings.hasPendingSync()) {
                            Settings.requestSync();
                        }
                    } else {
                        Log.v(LOG_TAG, "You are connected to Internet! but nothing has changed");
                    }
                } else {
                    Log.v(LOG_TAG, "You are not connected to Internet!");
                }
            }
        }
    }

    private void setNotificationProgress(String content, int totalcount, int progress, boolean indeterminate) {
        mBuilder.setContentText(content)
                .setProgress(totalcount, progress, indeterminate);
        mNotificationManager.notify(Constants.ID_SYNC, mBuilder.build());
    }

    private void showError(String text, String msg) {
        mNotificationManager.cancel(Constants.ID_SYNC);
        if (!mShowNotifications) {
            return;
        }
        Bitmap largeIcon = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.cloud_sync_error);

        int color = getContext().getResources().getColor(R.color.error_color);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                .setContentText(text)
                .setSmallIcon(R.mipmap.cloud_sync_error)
                .setLargeIcon(largeIcon)
                .setTicker(text)
                .setLights(color, 250, 500)
                .setContentTitle(text);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder.setPriority(Notification.PRIORITY_MAX);
        }
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(msg).setSummaryText(text));

        mNotificationManager.notify(Constants.ID_SYNC_ERROR, builder.build());
        /*
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                mNotificationManager.cancel(Constants.ID_SYNC_E
                RROR);
            }
        }, Constants.DEFAULT_ERROR_NOTIFICATION_DELAY_TIME);*/
    }

}
