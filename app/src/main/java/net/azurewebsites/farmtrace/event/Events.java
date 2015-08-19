package net.azurewebsites.farmtrace.event;

import net.azurewebsites.api.farmer.FarmerResponse;

import java.util.List;

/**
 * Created by sebichondo on 8/5/15.
 */
public class Events {
    public static class FarmerResponseEvent {

        List<FarmerResponse> farmerResponses;

    }

}
