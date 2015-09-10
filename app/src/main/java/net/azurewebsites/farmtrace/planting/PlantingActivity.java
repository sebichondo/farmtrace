package net.azurewebsites.farmtrace.planting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import net.azurewebsites.farmtrace.AppComponent;
import net.azurewebsites.farmtrace.BaseActivity;
import net.azurewebsites.farmtrace.DaggerMainComponent;
import net.azurewebsites.farmtrace.FarmerServiceModule;
import net.azurewebsites.farmtrace.HasComponent;
import net.azurewebsites.farmtrace.MainComponent;
import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.event.Events;
import net.azurewebsites.farmtrace.utils.EnumUtils;
import net.azurewebsites.farmtrace.utils.UiUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 9/8/15.
 */
public class PlantingActivity extends BaseActivity implements HasComponent<MainComponent> {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbartitle;


    private MainComponent mainComponent;

    protected final static String FIELD_ID = "FIELD_ID";
    protected final static String PLANTING_ACTIVITY_TYPE = "PLANTING_ACTIVITY_TYPE";

    private Long fieldID;
    private int plantingActivityTypeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        UiUtils.setStatusBarOneShadeDarker(getResources().getColor(R.color.primary_color), this);
        this.toolbar.setBackgroundColor(getResources().getColor(R.color.primary_color));
        this.setTitle("");
        this.toolbartitle.setText(getResources().getString(R.string.farmingActivities));

        fieldID = getIntent().getLongExtra(FIELD_ID,0);
        plantingActivityTypeID = getIntent().getIntExtra(PLANTING_ACTIVITY_TYPE, 0);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_view, PlantingActivityFragment.newInstance(fieldID,plantingActivityTypeID)).
                setTransition(FragmentTransaction.TRANSIT_NONE).
                commit();

        switch (plantingActivityTypeID) {
            case EnumUtils.FarmingActivityType.Planting:
                this.toolbartitle.setText("Planting");
                break;
            case EnumUtils.FarmingActivityType.CropProtection:
                this.toolbartitle.setText("Crop Protection");
                break;
            case EnumUtils.FarmingActivityType.FertilizerApplication:
                this.toolbartitle.setText("Fertilizer Application");
                break;
            case EnumUtils.FarmingActivityType.Irrigation:
                this.toolbartitle.setText("Irrigation Application");
                break;
        }
    }

    @Subscribe
    public void onSaveButtonClickEvent(Events.SaveButtonClickEvent event) {
        setResult(RESULT_OK);
        finish();
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setResult(RESULT_OK, data);
        finish();
    }

    public static Intent newInstance(Context context,Long fieldID,int plantingActivityTypeID) {
        Intent intent = new Intent(context, PlantingActivity.class);
        intent.putExtra(FIELD_ID, fieldID);
        intent.putExtra(PLANTING_ACTIVITY_TYPE, plantingActivityTypeID);
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
    public MainComponent getComponent() {
        return null;
    }
}
