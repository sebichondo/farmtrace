package net.azurewebsites.farmtrace.syncadapter.accounts;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import net.azurewebsites.farmtrace.LoginActivity;
import net.azurewebsites.farmtrace.datamodel.dao.User;

/**
 * Created by sebichondo on 9/11/15.
 */
public class Authenticator extends AbstractAccountAuthenticator {

    public static final String AUTHTOKEN_TYPE
            = "net.azurewebsites.farmtrace.sync";
    public static final String ACCOUNT_TYPE
            = "net.azurewebsites.farmtrace.sync";
    private final Context context;

    // Simple constructor
    public Authenticator(Context context) {
        super(context);
        this.context = context;
    }

    // Editing properties is not supported
    @Override
    public Bundle editProperties(
            AccountAuthenticatorResponse r, String s) {
        return null;

    }

    // Don't add additional accounts
    @Override
    public Bundle addAccount(
            AccountAuthenticatorResponse response,
            String accountType, String authTokenType,
            String[] requiredFeatures, Bundle options) throws NetworkErrorException {

        final Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(LoginActivity.ARG_ACCOUNT_TYPE, accountType);
        intent.putExtra(LoginActivity.ARG_AUTH_TYPE, authTokenType);
        intent.putExtra(LoginActivity.ARG_IS_ADDING_NEW_ACCOUNT, true);
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);

        final Bundle bundle = new Bundle();
        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        return bundle;

        //  return null;
    }

    // Ignore attempts to confirm credentials
    @Override
    public Bundle confirmCredentials(
            AccountAuthenticatorResponse r,
            Account account,
            Bundle bundle) throws NetworkErrorException {
        return null;
    }

    // Getting an authentication token is not supported
    @Override
    public Bundle getAuthToken(
            AccountAuthenticatorResponse response,
            Account account,
            String authTokenType,
            Bundle loginOptions) throws NetworkErrorException {

        // check and make sure it is the right token type we want
        if (!authTokenType.equals(AUTHTOKEN_TYPE)) {
            final Bundle result = new Bundle();
            result.putString(AccountManager.KEY_ERROR_MESSAGE,
                    "invalid authTokenType");
            return result;
        }
        final AccountManager am = AccountManager.get(context);
        // Extract the username and password from the Account Manager, and ask
        // the server for an appropriate AuthToken
        // Password is storing the refresh token
        String accessToken = "";
        final String password = am.getPassword(account);
        if (password != null) {
            try {
                User user = new User();
                user.setUserName(account.name);
                user.setUserPassword(password);
                //LoginResponse resp = FarmTraceApp.get().getService().refreshAccessToken(user);
                //accessToken = resp.getToken();
                //if (accessToken != null && !TextUtils.isEmpty(accessToken)) {
                loginOptions.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
                loginOptions.putString(AccountManager.KEY_ACCOUNT_TYPE, ACCOUNT_TYPE);
                loginOptions.putString(AccountManager.KEY_AUTHTOKEN, accessToken);
                //am.setPassword(account, accessToken.refreshToken);
                return loginOptions;
                //}
            } catch (Exception e) {

            }
        }
        // if we have the password, let's try and get the current
        // authtoken from the server

        if (!TextUtils.isEmpty(accessToken)) {
            final Bundle result = new Bundle();
            result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
            result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
            result.putString(AccountManager.KEY_AUTHTOKEN, accessToken);
            return result;
        }

        // if all else fails let's see about getting the user to log in
        Intent intent = new Intent(context, LoginActivity.class);
        //intent.putExtra(LoginActivity.PARAM_USERNAME, account.name);
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
        Bundle bundle = new Bundle();
        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        return bundle;

    }

    // Getting a label for the auth token is not supported
    @Override
    public String getAuthTokenLabel(String s) {
        return null;

    }

    // Updating user credentials is not supported
    @Override
    public Bundle updateCredentials(
            AccountAuthenticatorResponse r,
            Account account,
            String s, Bundle bundle) throws NetworkErrorException {
        return null;

    }

    // Checking features for the account is not supported
    @Override
    public Bundle hasFeatures(
            AccountAuthenticatorResponse r,
            Account account, String[] strings) throws NetworkErrorException {
        //throw new UnsupportedOperationException();
        return null;

    }
}