package net.azurewebsites.farmtrace.utils;

import net.azurewebsites.farmtrace.datamodel.dao.User;

/**
 * Created by sebichondo on 9/8/15.
 */
public class Settings {
    private static User currentUser;

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void setCurrentUser(User cu) {
        Settings.currentUser = cu;
    }
}

