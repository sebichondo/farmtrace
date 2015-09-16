package net.azurewebsites.farmtrace;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import net.azurewebsites.api.user.IUserService;
import net.azurewebsites.api.user.UserResponse;
import net.azurewebsites.farmtrace.datamodel.dao.User;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.syncadapter.accounts.Authenticator;
import net.azurewebsites.farmtrace.utils.Settings;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sebichondo on 8/3/15.
 */
public class LoginActivity extends BaseActivity implements HasComponent<MainComponent> {
    @Bind(R.id.btnLogIn)
    Button btnlogin;
    @Bind(R.id.txtUsername)
    EditText txtUserName;
    @Bind(R.id.txtPassword)
    EditText txtPassword;

    public final static String ARG_ACCOUNT_TYPE = "ACCOUNT_TYPE";
    public final static String ARG_AUTH_TYPE = "AUTH_TYPE";
    public final static String ARG_IS_ADDING_NEW_ACCOUNT = "IS_ADDING_ACCOUNT";
    private AccountManager mAccountManager;
    private Bundle mResultBundle = null;
    private AccountAuthenticatorResponse mAccountAuthenticatorResponse = null;
    private User loggedInUser;
    private MainComponent mainComponent;
    private String userName;

    @Inject
    IUserService userService;

    @OnClick(R.id.btnLogIn)
    public void login() {
        userName= txtUserName.getText().toString();
        String userPassword = txtPassword.getText().toString();
        loggedInUser = DataRepository.getUserByUserName(this, userName);

        if (loggedInUser != null) {
            Settings.setCurrentUser(loggedInUser);
            configureAccountInfo();
            startActivity(MainActivity.newIntent(this));
        } else {
            userService.getUsers(bus);
        }
    }

    @Subscribe
    public void onFetchUsersResponse(ArrayList<UserResponse> userResponses) {
        if (!userResponses.isEmpty() && userResponses.get(0) instanceof UserResponse) {
            for (UserResponse userResponse : userResponses) {
                if (userResponse.getUserName().equals(userName)){
                    loggedInUser=new User(userResponse.getUserID(),userResponse.getUserName()
                            ,userResponse.getUserPassword(),userResponse.getUserType(),userResponse.getUserStatus(),
                            "");
                    Settings.setCurrentUser(loggedInUser);
                    configureAccountInfo();
                    startActivity(MainActivity.newIntent(this));
                }
                else
                    showToast("Invalid user credentials");
            }
        }
    }

    private void configureAccountInfo() {
        final Account account = new Account(loggedInUser.getUserName(), Authenticator.ACCOUNT_TYPE);
        Bundle data = new Bundle();
        data.putString(AccountManager.KEY_ACCOUNT_NAME, loggedInUser.getUserName());
        data.putString(AccountManager.KEY_ACCOUNT_TYPE, Authenticator.ACCOUNT_TYPE);
        //data.putString(AccountManager.KEY_AUTHTOKEN, access_token);

        Bundle userData = new Bundle();
        userData.putString("userId", String.valueOf(loggedInUser.getUserID()));
        data.putBundle(AccountManager.KEY_USERDATA, userData);

        Intent intent = new Intent();
        intent.putExtras(data);

        mAccountManager.addAccountExplicitly(account, "", userData);
        //mAccountManager.setAuthToken(account, Authenticator.AUTHTOKEN_TYPE, access_token);

        if (getIntent().getBooleanExtra(LoginActivity.ARG_IS_ADDING_NEW_ACCOUNT, false)) {
            Log.d("LoginActivity", "MAccount Manager NIKO PHAPA NDANI");
            //setAccountAuthenticatorResult(intent.getExtras());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        Settings.configureSync(account);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAccountManager = AccountManager.get(this);

        mAccountAuthenticatorResponse =
                getIntent().getParcelableExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE);

        if (mAccountAuthenticatorResponse != null) {
            mAccountAuthenticatorResponse.onRequestContinued();
        }
        Settings.createInstance(this.getBaseContext());
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mainComponent = DaggerMainComponent.builder()
                .appComponent(appComponent)
                .farmerServiceModule(new FarmerServiceModule())
                .build();
        mainComponent.inject(this);
    }


    private void showToast(String message) {

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.toast, null);

        TextView text = (TextView) layout.findViewById(R.id.toastText);
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

        toast.setView(layout);
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public MainComponent getComponent() {
        return null;
    }
}
