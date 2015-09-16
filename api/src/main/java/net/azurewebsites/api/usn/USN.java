package net.azurewebsites.api.usn;

import java.util.Date;

/**
 * Created by sebichondo on 9/12/15.
 */
public class USN {
    private Long UpdateSequenceNumberID;
    private Date USNDate;
    private Long UserID;
    private Long AppUSNID;

    public USN(Long updateSequenceNumberID, Date USNDate, Long userID, Long appUSNID) {
        UpdateSequenceNumberID = updateSequenceNumberID;
        this.USNDate = USNDate;
        UserID = userID;
        AppUSNID = appUSNID;
    }

    public Long getUpdateSequenceNumberID() {
        return UpdateSequenceNumberID;
    }

    public void setUpdateSequenceNumberID(Long updateSequenceNumberID) {
        UpdateSequenceNumberID = updateSequenceNumberID;
    }

    public Date getUSNDate() {
        return USNDate;
    }

    public void setUSNDate(Date USNDate) {
        this.USNDate = USNDate;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public Long getAppUSNID() {
        return AppUSNID;
    }

    public void setAppUSNID(Long appUSNID) {
        AppUSNID = appUSNID;
    }
}
