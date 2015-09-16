package net.azurewebsites.farmtrace.utils;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.widget.Toast;

import net.azurewebsites.farmtrace.datamodel.dao.User;
import net.azurewebsites.farmtrace.syncadapter.accounts.Authenticator;
import net.azurewebsites.farmtrace.syncadapter.accounts.providers.FarmTraceContentProvider;

import java.util.ArrayList;

/**
 * Created by sebichondo on 9/8/15.
 */
public class Settings implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static boolean pendingsynch;
    private ArrayList<Handler> mObservers;
    private static Settings mInstance;
    private static SharedPreferences mSharedPreferences;
    private static User currentUser;
    private static Context mOwner;
    private static String versionName;
    private static int versionCode = 0;
    private static String packageName;
    private static final String currentUserKey="currentUser";
    private static boolean syncShowNotifications;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User cu) {
        Settings.currentUser = cu;
        SharedPreferences.Editor edit = Settings.mSharedPreferences.edit();
        edit.putString(currentUserKey, cu.toString());
        edit.commit();
    }


    public static void configureSync(Account account) {
        // Which provider's synchroniser are we configuring?
        String providerAuthority = FarmTraceContentProvider.CONTENT_AUTHORITY;
        // Is it possible to sync?
        ContentResolver.setIsSyncable(account, providerAuthority, 1);
        // Should sync be done automatically by Android when the provider
        // sends a notifyChange() with syncToNetwork set to true?
        ContentResolver.setSyncAutomatically(account, providerAuthority, true);
        ContentResolver.setMasterSyncAutomatically(true);
        // Set some sync parameters
        // How often should automatic sync be done? (say 15 minutes)
        /*
        Bundle params = new Bundle();
        params.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, false);
        params.putBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, false);
        params.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, false);

        ContentResolver.addPeriodicSync(account, providerAuthority, params, Constants.SYNC_TIME_MINS*60);
        */
        // Request a sync right now
        //  ContentResolver.requestSync(account, providerAuthority, params);
    }


    public static void checkifSyncisOn(Context ctx) {
        User cu = getCurrentUser();
        if (cu != null) {
            // AccountManager am = AccountManager.get(ctx);
            final Account account = new Account(cu.getUserName(), Authenticator.ACCOUNT_TYPE);
            String providerAuthority = FarmTraceContentProvider.CONTENT_AUTHORITY;

            boolean isYourAccountSyncEnabled = ContentResolver.getSyncAutomatically(account, providerAuthority);
            boolean isMasterSyncEnabled = ContentResolver.getMasterSyncAutomatically();
            //res = new boolean[]{isMasterSyncEnabled, isYourAccountSyncEnabled};

            if (!isMasterSyncEnabled) {
                Toast.makeText(ctx, "Master Sync setting is off - put it on to push your updates to the server", Toast.LENGTH_SHORT).show();
            } else if (!isYourAccountSyncEnabled) {
                Toast.makeText(ctx, "FarmTrace's Account Sync setting is turned off - turn it on to push your updates to the server", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public static void requestSync() {
        User cu = getCurrentUser();
        if (cu != null) {
            // (Not setting the auth token will cause another call to the server to authenticate the user)
            final Account account = new Account(cu.getUserName(), Authenticator.ACCOUNT_TYPE);
            // final Account account = new Account(cu.getUserAccountName(), Authenticator.ACCOUNT_TYPE);

            // Which provider's synchroniser are we configuring?
            String providerAuthority = FarmTraceContentProvider.CONTENT_AUTHORITY;
            Bundle params = new Bundle();
            params.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
            params.putBoolean(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY, true);
            params.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
            /*
              Bundle b = new Bundle();
            // Disable sync backoff and ignore sync preferences. In other words...perform sync NOW!
            b.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
            b.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);

             */
            setHasPendingSync(true);
            ContentResolver.requestSync(account, providerAuthority, params);
        }
    }

    public static boolean hasPendingSync() {
        // final SharedPreferences prefs = getGcmPreferences(context);
        return Settings.pendingsynch;

    }



    public static void setHasPendingSync(boolean val){
        Settings.pendingsynch=val;
        final SharedPreferences.Editor edit = Settings.mSharedPreferences.edit();
        edit.putBoolean("pendingsynch", val);
        edit.commit();
        notifyAllObservers();
    }

    private static void notifyAllObservers() {
        notifyAllObservers(null);
    }

    private static void notifyAllObservers(final String s) {
        final Settings instance = getInstance();
        if (instance != null) {
            instance.notifyObservers(s);
        }
    }

    private void notifyObservers(final String s) {
        synchronized (this) {
            if (this.mObservers != null) {
                for (final Handler handler : this.mObservers) {
                    handler.removeMessages(0);
                    handler.sendMessage(Message.obtain(handler, 0, (Object) s));
                }
            }
        }
        // monitorexit(this)
    }

    private static void readManifest(final Context context) {
        try {
            Settings.versionCode = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
            Settings.versionName = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionName;
            Settings.packageName = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException ex) {
        } catch (NullPointerException ex2) {
        }
    }



    private Settings(final Context context) {
        super();
        Settings.mOwner = context.getApplicationContext();
        Settings.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settings.mOwner);

        readManifest(context);
        getSettingsFromPreferences();
        Settings.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        final ApplicationInfo applicationInfo = Settings.mOwner.getApplicationInfo();
        final int flags = 0x2 & applicationInfo.flags;
        applicationInfo.flags = flags;

    }

    public static boolean getSyncShowNotifications() {
        return syncShowNotifications;
    }

    public void getSettingsFromPreferences() {

        //Settings.secureToken = Settings.mSharedPreferences.getString(secureTokenKey, "");
        //Settings.fbLoginToken = Settings.mSharedPreferences.getString(fbLoginTokenKey, null);
        String custring = Settings.mSharedPreferences.getString(currentUserKey,null);
        Settings.pendingsynch= Settings.mSharedPreferences.getBoolean("pendingsynch",false);
        //Settings.dummydataputin= Settings.mSharedPreferences.getBoolean("DummyDataGen",false);
        //Settings.playedCongrats= Settings.mSharedPreferences.getBoolean("playedCongrats",false);
        Settings.syncShowNotifications= Settings.mSharedPreferences.getBoolean("syncShowNotifications",true);

        if(custring != null){
            currentUser=getCurrentUser();
        } else {
            currentUser=null;
        }
    }

    public static Settings createInstance(final Context context) {
        if (Settings.mInstance == null) {
            Settings.mInstance = new Settings(context);
        }
        return Settings.mInstance;
    }

    public static Settings getInstance() {
        return Settings.mInstance;
    }

    public void registerObserver(final Handler handler) {
        synchronized (this) {
            if (this.mObservers == null) {
                this.mObservers = new ArrayList<Handler>();
            }
            this.mObservers.add(handler);
        }
    }

    public void unregisterAllObservers() {
        synchronized (this) {
            this.mObservers = null;
        }
    }

    public void unregisterObserver(final Handler handler) {
        synchronized (this) {
            if (this.mObservers != null) {
                this.mObservers.remove(handler);
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}