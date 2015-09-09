package net.azurewebsites.farmtrace.event;

/**
 * Created by sebichondo on 8/5/15.
 */
public class Events {
    public static class FarmersSelectedEvent {

    }

    public static class FabButtonClickEvent {
        public boolean expanded;

        public FabButtonClickEvent(boolean expanded) {
            this.expanded = expanded;
        }
    }


    public static class CropsSelectedEvent {

    }

    public static class FarmInputsSelectedEvent {

    }

    public static class CloseDrawerEvent {

    }

    public static class DashboardSelectedEvent {

    }
}
