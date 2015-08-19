package net.azurewebsites.api;

import retrofit.RetrofitError;

/**
 * Created by sebichondo on 8/13/15.
 */
public class RetrofitErrorEvent {

    private RetrofitError error;
    private long requestId;
    private String errorMessage;

    public RetrofitErrorEvent(long requestId, RetrofitError error, String errorMessage) {
        this.requestId = requestId;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public RetrofitError getRetrofitError() {
        return error;
    }

    public long getRequestId() {
        return requestId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
