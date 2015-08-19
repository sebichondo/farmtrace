package net.azurewebsites.farmtrace;

import android.app.Activity;
import android.view.ViewGroup;

import static butterknife.ButterKnife.findById;

/**
 * Created by sebichondo on 8/13/15.
 */
public interface AppContainer {
    ViewGroup get(Activity activity);

    /**
     * An {@link AppContainer} which returns the normal activity content view.
     */
    AppContainer DEFAULT = new AppContainer() {
        @Override
        public ViewGroup get(Activity activity) {
            return findById(activity, android.R.id.content);
        }
    };
}
