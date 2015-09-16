package net.azurewebsites.api.plantingactivity;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 9/14/15.
 */
public class UpdateSequenceNumber {
    @Expose
    private Integer UpdateSequenceNumberID;
    @Expose
    private String USNDate;
    @Expose
    private Integer UserID;
    @Expose
    private User User;


    public Integer getUpdateSequenceNumberID() {
        return UpdateSequenceNumberID;
    }

    /**
     *
     * @param UpdateSequenceNumberID
     * The UpdateSequenceNumberID
     */
    public void setUpdateSequenceNumberID(Integer UpdateSequenceNumberID) {
        this.UpdateSequenceNumberID = UpdateSequenceNumberID;
    }

    /**
     *
     * @return
     * The USNDate
     */
    public String getUSNDate() {
        return USNDate;
    }

    /**
     *
     * @param USNDate
     * The USNDate
     */
    public void setUSNDate(String USNDate) {
        this.USNDate = USNDate;
    }

    /**
     *
     * @return
     * The UserID
     */
    public Integer getUserID() {
        return UserID;
    }

    /**
     *
     * @param UserID
     * The UserID
     */
    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }

    /**
     *
     * @return
     * The User
     */
    public User getUser() {
        return User;
    }

    /**
     *
     * @param User
     * The User
     */
    public void setUser(User User) {
        this.User = User;
    }

}
