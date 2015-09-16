package net.azurewebsites.api.usn;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 9/12/15.
 */
public class USNResponse {
    @Expose
    private Long UpdateSequenceNumberID;
    @Expose
    private String USNDate;
    @Expose
    private Long UserID;


    /**
     * @return The UpdateSequenceNumberID
     */
    public Long getUpdateSequenceNumberID() {
        return UpdateSequenceNumberID;
    }

    /**
     * @param UpdateSequenceNumberID The UpdateSequenceNumberID
     */
    public void setUpdateSequenceNumberID(Long UpdateSequenceNumberID) {
        this.UpdateSequenceNumberID = UpdateSequenceNumberID;
    }

    /**
     * @return The USNDate
     */
    public String getUSNDate() {
        return USNDate;
    }

    /**
     * @param USNDate The USNDate
     */
    public void setUSNDate(String USNDate) {
        this.USNDate = USNDate;
    }

    /**
     * @return The UserID
     */
    public Long getUserID() {
        return UserID;
    }

    /**
     * @param UserID The UserID
     */
    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }
}

