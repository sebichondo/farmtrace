package net.azurewebsites.farmtrace;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;

import net.azurewebsites.farmtrace.event.BusProvider;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by sebichondo on 8/14/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    AppContainer appContainer;
    protected Bus bus = BusProvider.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_toolbar);
        FarmTraceApp app = FarmTraceApp.get(this);
        onCreateComponent(app.component());

        if(appContainer == null ){
            throw new IllegalStateException("No injection happened. Add component.inject(this) in onCreateComponent.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    /**
     * Must be implemented by derived activities.
     * Otherwise IllegalStateException will be thrown.
     * Derived activity is responsible to store and save it's component.
     */
    protected abstract void onCreateComponent(AppComponent appComponent);

}
