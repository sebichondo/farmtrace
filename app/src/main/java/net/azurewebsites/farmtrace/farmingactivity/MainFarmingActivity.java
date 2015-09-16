package net.azurewebsites.farmtrace.farmingactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import net.azurewebsites.farmtrace.AppComponent;
import net.azurewebsites.farmtrace.BaseActivity;
import net.azurewebsites.farmtrace.DaggerMainComponent;
import net.azurewebsites.farmtrace.FarmerServiceModule;
import net.azurewebsites.farmtrace.HasComponent;
import net.azurewebsites.farmtrace.MainComponent;
import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.fragment.FarmingActivityFragment;
import net.azurewebsites.farmtrace.utils.UiUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 9/5/15.
 */
public class MainFarmingActivity extends BaseActivity implements HasComponent<MainComponent> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbartitle;

    private MainComponent mainComponent;
    protected final static String FIELD_ID = "FIELD_ID";
    protected final static String FIELD_DESC = "FIELD_DESC";
    protected final static String FARMER_DESC = "FARMER_DESC";

    private Long fieldID;
    private String fieldDesc;
    private String farmerDesc;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setResult(RESULT_OK, data);
        finish();
    }

    public static Intent newInstance(Context context, Long fieldID, String fieldDesc, String farmerDesc) {
        Intent intent = new Intent(context, MainFarmingActivity.class);
        intent.putExtra(FIELD_ID, fieldID);
        intent.putExtra(FIELD_DESC, fieldDesc);
        intent.putExtra(FARMER_DESC, farmerDesc);
        return intent;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.white_arrow);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setResult(RESULT_CANCELED);
                    finish();
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        UiUtils.setStatusBarOneShadeDarker(getResources().getColor(R.color.primary_color), this);
        this.toolbar.setBackgroundColor(getResources().getColor(R.color.primary_color));
        this.setTitle("");
        this.toolbartitle.setText(getResources().getString(R.string.farmingActivities));

        fieldID = getIntent().getLongExtra(FIELD_ID, 0);
        fieldDesc = getIntent().getStringExtra(FIELD_DESC);
        farmerDesc = getIntent().getStringExtra(FARMER_DESC);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_view, FarmingActivityFragment.newInstance(fieldID, fieldDesc, farmerDesc)).
                setTransition(FragmentTransaction.TRANSIT_NONE).
                commit();
        this.toolbartitle.setText("Choose Farming Activity");
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mainComponent = DaggerMainComponent.builder()
                .appComponent(appComponent)
                .farmerServiceModule(new FarmerServiceModule())
                .build();
        mainComponent.inject(this);
    }

    @Override
    public MainComponent getComponent() {
        return null;
    }
}
