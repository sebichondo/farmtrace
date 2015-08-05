package net.azurewebsites.farmtrace;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import net.azurewebsites.farmtrace.utils.UiUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbartitle;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.content_view)
    View mainContentView;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.empty_string, R.string.empty_string);
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            setToolbarTransparent(false);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
        //return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void setToolbarTransparent(boolean transparent) {
        if (transparent) {
            this.toolbar.setBackgroundColor(0x00000000);
            this.setTitle("Dashboard");
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainContentView.getLayoutParams();
            params.setMargins(0, 0, 0, 0);
            this.mainContentView.setLayoutParams(params);

        } else {
            UiUtils.setStatusBarOneShadeDarker(getResources().getColor(R.color.primary_color), this);
            this.toolbar.setBackgroundColor(getResources().getColor(R.color.primary_color));
            this.setTitle("");
            this.toolbartitle.setText("Dashboard");
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainContentView.getLayoutParams();
            params.setMargins(0, this.toolbar.getHeight(), 0, 0);
            this.mainContentView.setLayoutParams(params);
        }

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public static Intent newIntent(Context context) {
        Intent ret = new Intent(context, MainActivity.class);
        return ret;
    }
}
