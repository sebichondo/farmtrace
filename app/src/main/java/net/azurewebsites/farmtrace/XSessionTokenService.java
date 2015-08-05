package net.azurewebsites.farmtrace;

/**
 * Created by sebichondo on 8/4/15.
 */
public class XSessionTokenService {
    private static String xSession="";

    public static synchronized String getSessionToken(){
        return xSession;
    }

    public static synchronized void setSessionToken(String token){
        xSession = token;
    }

}

