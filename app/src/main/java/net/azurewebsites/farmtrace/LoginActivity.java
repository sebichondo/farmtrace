package net.azurewebsites.farmtrace;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.azurewebsites.api.user.IUserService;
import net.azurewebsites.farmtrace.datamodel.dao.User;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.utils.Settings;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sebichondo on 8/3/15.
 */
public class LoginActivity extends BaseDetailActivity {
    @Bind(R.id.btnLogIn)
    Button btnlogin;
    @Bind(R.id.txtUsername)
    EditText txtUserName;
    @Bind(R.id.txtPassword)
    EditText txtPassword;

    @Inject
    IUserService userService;

    @OnClick(R.id.btnLogIn)
    public void login() {
        String userName = txtUserName.getText().toString();
        String userPassword = txtPassword.getText().toString();
        User loggedInUser = DataRepository.getUserByUserName(this, userName);
        if (loggedInUser != null)
        {
            Settings.setCurrentUser(loggedInUser);
            startActivity(MainActivity.newIntent(this));
        }
        else
            showToast("Invalid user credentials");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    private void showToast(String message){

        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.toast,null);

        TextView text = (TextView) layout.findViewById(R.id.toastText);
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

        toast.setView(layout);
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }


}
