package net.azurewebsites.farmtrace;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;

import net.azurewebsites.farmtrace.event.BusProvider;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by sebichondo on 8/3/15.
 */
public class BaseDetailActivity extends AppCompatActivity {
    protected Bus bus = BusProvider.getInstance();

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_toolbar);
    }
}
