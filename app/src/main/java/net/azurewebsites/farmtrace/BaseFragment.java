package net.azurewebsites.farmtrace;

import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;

import net.azurewebsites.farmtrace.event.BusProvider;

/**
 * Created by sebichondo on 8/4/15.
 */
public class BaseFragment extends Fragment {
    protected Bus bus = BusProvider.getInstance();

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }
}
