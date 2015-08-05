package net.azurewebsites.farmtrace;

import android.app.Application;

import net.azurewebsites.farmtrace.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by sebichondo on 8/4/15.
 */
public class FarmTraceApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/kontrapunkt_light.otf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
