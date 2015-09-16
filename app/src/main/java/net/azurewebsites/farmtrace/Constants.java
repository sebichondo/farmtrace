package net.azurewebsites.farmtrace;

/**
 * Created by sebichondo on 8/5/15.
 */
public class Constants {
    public static final String ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
    public static final String ACCOUNT_TYPE = "_ACCOUNT_TYPE";
    public static final String LOG_TAG = "FarmTrace Log: ";

    public static final int FARMING_ACTIVITY_CODE = 200;
    public static final int PLANTING_ACTIVITY_CODE = 201;
    public static final int GPS_MIN_WAIT_TIME = 1000 * 60 * 3;// three minutes
    public static final int NETWORK_MIN_WAIT_TIME = 1000 * 60 * 1;// 1 minutes
    public static final int TWO_MINUTES = 1000 * 60 * 2;
    public static final float MIN_DISTANCE = 50;

    public static final int ID_SYNC = 191919;
    public static final int  ID_SYNC_ERROR=99999;
    public static final int MAX_COMMENTS = 10;


    public static class IntentRequestCode {
        public static final int STOP_CHEQUE_REQUEST_CODE = 100;
        public static final int EDIT_ACCOUNT_NAME_LABEL_REQUEST_CODE = 105;
        public static final int GET_PIC = 11106;
        public static final int PIC_CROP = 11108;
    }

}
