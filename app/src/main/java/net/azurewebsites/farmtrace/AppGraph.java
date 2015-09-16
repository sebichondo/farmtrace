package net.azurewebsites.farmtrace;

/**
 * Created by sebichondo on 8/14/15.
 */
public interface AppGraph {
    void inject(FarmTraceApp app);

    AppContainer appContainer();
    //Picasso picasso();
}
