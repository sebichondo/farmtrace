package net.azurewebsites.farmtrace;

import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sebichondo on 8/3/15.
 */
public class LoginActivity extends BaseDetailActivity {
    @Bind(R.id.btnLogIn)
    Button btnlogin;

    @OnClick(R.id.btnLogIn)
    public void login(){
        startActivity(MainActivity.newIntent(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }
}
