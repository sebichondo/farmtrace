package net.azurewebsites.farmtrace.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import net.azurewebsites.farmtrace.Constants;

/**
 * Created by sebichondo on 9/9/15.
 */
public class FieldLocationManager {
    private LocationManager locationManager;
    private boolean gpsEnabled = false;
    private boolean networkEnabled = false;
    private ServiceLocationListener gpsLocationListener;
    private ServiceLocationListener networkLocationListener;
    private Context basecontext;
    protected Location currentLocation;
    LocationProviderChangedReceiver receiver;

    public Location getCurrentLocation() {
        return currentLocation;
    }

    private static FieldLocationManager mInstance;

    private FieldLocationManager(Context context) {
        super();
        this.basecontext = context;

        checkLocations();
        createLocationServices();
        startLocationMonitoring();

    }

    public static FieldLocationManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new FieldLocationManager(context);
        }
        return mInstance;
    }

    private void checkLocations() {
        locationManager = (LocationManager) basecontext.getSystemService(
                Context.LOCATION_SERVICE);
        try {
            gpsEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            networkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

    }

    private void startLocationMonitoring() {
        IntentFilter filter = new IntentFilter(LocationManager.PROVIDERS_CHANGED_ACTION);
        receiver = new LocationProviderChangedReceiver();
        basecontext.registerReceiver(receiver, filter);
    }

    private void createLocationServices() {
        Criteria criteria = new Criteria();
        String best = locationManager.getBestProvider(criteria, true);
        // since you are using true as the second parameter, you will only get
        // the best of providers which are enabled.
        currentLocation = locationManager.getLastKnownLocation(best);


        gpsLocationListener = new ServiceLocationListener();
        networkLocationListener = new ServiceLocationListener();

        if (gpsEnabled) {
            // gpsLocationListener.onLocationChanged(gloc);
            gpsLocationListener.onLocationChanged(currentLocation);
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    Constants.GPS_MIN_WAIT_TIME, Constants.MIN_DISTANCE,
                    gpsLocationListener);
        }

        if (networkEnabled) {
            if (!gpsEnabled) {
                networkLocationListener.onLocationChanged(currentLocation);
            }
            // networkLocationListener.onLocationChanged(gloc);
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    Constants.NETWORK_MIN_WAIT_TIME,
                    Constants.MIN_DISTANCE, networkLocationListener);
        }

    }


    /**
     * Determines whether one Location reading is better than the current Location fix
     *
     * @param location            The new Location that you want to evaluate
     * @param currentBestLocation The current Location fix, to which you want to compare the new one
     */
    public static boolean isBetterLocation(Location location, Location currentBestLocation) {
        if (currentBestLocation == null) {
            // A new location is always better than no location
            return true;
        }

        // Check whether the new location fix is newer or older
        long timeDelta = location.getTime() - currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > Constants.TWO_MINUTES;
        boolean isSignificantlyOlder = timeDelta < -Constants.TWO_MINUTES;
        boolean isNewer = timeDelta > 0;

        // If it's been more than two minutes since the current location, use the new location
        // because the user has likely moved
        if (isSignificantlyNewer) {
            return true;
            // If the new location is more than two minutes older, it must be worse
        } else if (isSignificantlyOlder) {
            return false;
        }

        // Check whether the new location fix is more or less accurate
        int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;

        // Check if the old and new location are from the same provider
        boolean isFromSameProvider = isSameProvider(location.getProvider(),
                currentBestLocation.getProvider());

        // Determine location quality using a combination of timeliness and accuracy
        if (isMoreAccurate) {
            return true;
        } else if (isNewer && !isLessAccurate) {
            return true;
        } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
            return true;
        }
        return false;
    }


    /**
     * Checks whether two providers are the same
     */
    private static boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }


    private class ServiceLocationListener implements
            android.location.LocationListener {

        // @Override
        public void onLocationChanged(Location d) {
            // synchronized (this) {

            if (d == null)
                return;

            if (isBetterLocation(d, currentLocation)) {
                currentLocation = d;
            }

            // }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        // @Override
        public void onProviderEnabled(String provider) {

        }

        // @Override
        public void onProviderDisabled(String provider) {

        }
    }

    public class LocationProviderChangedReceiver extends BroadcastReceiver {
        private final static String TAG = "LocationProviderChangedReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
                checkLocations();
            }
        }
    }
}
