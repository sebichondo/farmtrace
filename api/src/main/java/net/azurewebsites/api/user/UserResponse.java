package net.azurewebsites.api.user;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 9/8/15.
 */
public class UserResponse {
    @Expose
    private Long UserID;
    @Expose
    private Integer UserType;
    @Expose
    private String UserName;
    @Expose
    private String UserPassword;
    @Expose
    private Integer UserStatus;

    public UserResponse(Long userID, Integer userType, String userName, String userPassword, Integer userStatus) {
        UserID = userID;
        UserType = userType;
        UserName = userName;
        UserPassword = userPassword;
        UserStatus = userStatus;
    }

    /**
     *
     * @return
     * The UserID
     */
    public Long getUserID() {
        return UserID;
    }

    /**
     *
     * @param UserID
     * The UserID
     */
    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    /**
     *
     * @return
     * The UserType
     */
    public Integer getUserType() {
        return UserType;
    }

    /**
     *
     * @param UserType
     * The UserType
     */
    public void setUserType(Integer UserType) {
        this.UserType = UserType;
    }

    /**
     *
     * @return
     * The UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     *
     * @param UserName
     * The UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     *
     * @return
     * The UserPassword
     */
    public String getUserPassword() {
        return UserPassword;
    }

    /**
     *
     * @param UserPassword
     * The UserPassword
     */
    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    /**
     *
     * @return
     * The UserStatus
     */
    public Integer getUserStatus() {
        return UserStatus;
    }

    /**
     *
     * @param UserStatus
     * The UserStatus
     */
    public void setUserStatus(Integer UserStatus) {
        this.UserStatus = UserStatus;
    }
}
