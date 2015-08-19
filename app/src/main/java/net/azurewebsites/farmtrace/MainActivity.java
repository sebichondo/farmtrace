package net.azurewebsites.farmtrace;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import net.azurewebsites.api.crop.CropResponse;
import net.azurewebsites.api.crop.ICropService;
import net.azurewebsites.api.farmer.FarmerResponse;
import net.azurewebsites.api.farmer.IFarmerService;
import net.azurewebsites.api.group.GroupResponse;
import net.azurewebsites.api.group.IGroupService;
import net.azurewebsites.farmtrace.datamodel.dao.Crop;
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroup;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbartitle;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.content_view)
    View mainContentView;


    @Inject
    IFarmerService farmerService;
    @Inject
    ICropService cropService;
    @Inject
    IGroupService groupService;

    private ActionBarDrawerToggle drawerToggle;
    //private Bus bus = BusProvider.getInstance();
    private MainComponent mainComponent;

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

        loadMasterData();
        List<Crop> crops=DataRepository.getAllCrops(this);
        Log.d("MainActivity", "The Number of Crops: " + crops.size());

    }

    private void loadMasterData(){

        cropService.getCrops(bus);
        groupService.getGroups(bus);
        farmerService.getFarmers(bus);
    }

    @Subscribe
    public void onFetchGroupsResponse(ArrayList<GroupResponse> groupResponses){
        if(!groupResponses.isEmpty() && groupResponses.get(0) instanceof GroupResponse) {
            Log.d("MainActivity", "AM HERE Groups Num;ber: " + groupResponses.size());
            for (GroupResponse groupResponse : groupResponses) {
                FarmerGroup farmerGroup = new FarmerGroup(groupResponse.getGroupID(), groupResponse.getGroupName(),
                        groupResponse.getTelephone(),groupResponse.getEmailAddress(),groupResponse.getContactPerson(),
                        groupResponse.getAddress(),groupResponse.getCropID());
                DataRepository.insertOrUpdateFarmerGroup(this, farmerGroup);
                Log.d("MainActivity", "AM HERE Groups : " + farmerGroup.getCropID());
            }
        }
    }


    @Subscribe
    public void onFetchCropsResponse(ArrayList<CropResponse> cropResponses){
        if(!cropResponses.isEmpty() && cropResponses.get(0) instanceof CropResponse) {
            for (CropResponse cropResponse : cropResponses) {
                Crop crop = new Crop(cropResponse.getCropID(), cropResponse.getCropName(), cropResponse.getCropVariety());
                DataRepository.insertOrUpdateCrop(this, crop);
                Log.d("MainActivity", "AM HERE Crops : " + crop.getCropID());
            }
        }
    }

    @Subscribe
    public void onFetchFarmersResponse(ArrayList<FarmerResponse> farmerResponses){
        Log.d("MainActivity", "onFetchFarmersResponse: " + farmerResponses.size());
        if(!farmerResponses.isEmpty() && farmerResponses.get(0) instanceof FarmerResponse) {
            for (FarmerResponse farmerResponse : farmerResponses) {
                Log.d("MainActivity", "Farmer ID: " + farmerResponse.toString());
                Farmer farmer = new Farmer(farmerResponse.getFarmerID(), farmerResponse.getNames(),
                        farmerResponse.getNames(), farmerResponse.getTelephone(), farmerResponse.getAddress(),
                        farmerResponse.getFarmerID());
                DataRepository.insertOrUpdateFarmer(this, farmer);
                Log.d("MainActivity", "AM HERE BOSS : " + farmer.getFarmerID());
            }
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

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mainComponent = DaggerMainComponent.builder()
                .appComponent(appComponent)
                .farmerServiceModule(new FarmerServiceModule())
                .build();
        mainComponent.inject(this);
    }

    public void setToolbarTransparent(boolean transparent) {
        if (transparent) {
            this.toolbar.setBackgroundColor(0x00000000);
            this.setTitle("");
            this.toolbartitle.setText("Dashboard");
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

    @Override
    public MainComponent getComponent() {
        return null;
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
        //BusProvider.getInstance().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
        //BusProvider.getInstance().register(this);
    }
}
