package net.azurewebsites.farmtrace;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.azurewebsites.farmtrace.datamodel.dao.DaoMaster;
import net.azurewebsites.farmtrace.datamodel.dao.DaoSession;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by sebichondo on 8/4/15.
 */
public class FarmTraceApp extends Application {
    private AppComponent component;
    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/kontrapunkt_light.otf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
        buildComponentAndInject();
        setupDatabase();
    }
    /**
     * Initialize our root AppComponent, kick off our dependency resolutions
     */
    public void buildComponentAndInject() {
        component = AppComponent.Initializer.init(this);
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static FarmTraceApp get(Context context) {
        return (FarmTraceApp) context.getApplicationContext();
    }


    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "farmtrace-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
