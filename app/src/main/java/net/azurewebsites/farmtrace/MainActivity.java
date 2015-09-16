package net.azurewebsites.farmtrace;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import net.azurewebsites.api.chemical.ChemicalResponse;
import net.azurewebsites.api.chemical.IChemicalService;
import net.azurewebsites.api.crop.CropResponse;
import net.azurewebsites.api.crop.ICropService;
import net.azurewebsites.api.farmer.FarmerResponse;
import net.azurewebsites.api.farmer.IFarmerService;
import net.azurewebsites.api.fertilizer.FertilizerResponse;
import net.azurewebsites.api.fertilizer.IFertilizerService;
import net.azurewebsites.api.field.FieldResponse;
import net.azurewebsites.api.field.IFieldService;
import net.azurewebsites.api.group.GroupResponse;
import net.azurewebsites.api.group.IGroupService;
import net.azurewebsites.api.plantingseason.IPlantingSeasonService;
import net.azurewebsites.api.plantingseason.PlantingSeasonResponse;
import net.azurewebsites.api.seed.ISeedService;
import net.azurewebsites.api.seed.SeedResponse;
import net.azurewebsites.api.user.IUserService;
import net.azurewebsites.api.user.UserResponse;
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;
import net.azurewebsites.farmtrace.datamodel.dao.Crop;
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroup;
import net.azurewebsites.farmtrace.datamodel.dao.Fertilizer;
import net.azurewebsites.farmtrace.datamodel.dao.Field;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingSeason;
import net.azurewebsites.farmtrace.datamodel.dao.Seed;
import net.azurewebsites.farmtrace.datamodel.dao.User;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.event.Events;
import net.azurewebsites.farmtrace.fragment.DashboardFragment;
import net.azurewebsites.farmtrace.fragment.FarmInputsFragment;
import net.azurewebsites.farmtrace.fragment.FarmerFragment;
import net.azurewebsites.farmtrace.fragment.PlantingSeasonFragment;
import net.azurewebsites.farmtrace.utils.UiUtils;

import java.util.ArrayList;

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
    @Inject
    IFieldService fieldService;
    @Inject
    IPlantingSeasonService plantingSeasonService;
    @Inject
    IFertilizerService fertilizerService;
    @Inject
    IChemicalService chemicalService;
    @Inject
    ISeedService seedService;
    @Inject
    IUserService userService;

    private ActionBarDrawerToggle drawerToggle;
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
            getSupportFragmentManager().beginTransaction().replace(R.id.content_view, new DashboardFragment()).
                    setTransition(FragmentTransaction.TRANSIT_NONE).
                    commit();
            setToolbarTransparent(true);
        }

        loadMasterData();
    }

    private void loadMasterData() {
        cropService.getCrops(bus);
        groupService.getGroups(bus);
        farmerService.getFarmers(bus);
        fieldService.getFields(bus);
        plantingSeasonService.getPlantingSeasons(bus);
        fertilizerService.getFertilizers(bus);
        chemicalService.getChemicals(bus);
        seedService.getSeeds(bus);
        userService.getUsers(bus);
    }

    @Subscribe
    public void onFetchGroupsResponse(ArrayList<GroupResponse> groupResponses) {
        if (!groupResponses.isEmpty() && groupResponses.get(0) instanceof GroupResponse) {
            for (GroupResponse groupResponse : groupResponses) {
                FarmerGroup farmerGroup = new FarmerGroup(groupResponse.getGroupID(), groupResponse.getGroupName(),
                        groupResponse.getTelephone(), groupResponse.getEmailAddress(), groupResponse.getContactPerson(),
                        groupResponse.getAddress(), groupResponse.getCropID());
                DataRepository.insertOrUpdateFarmerGroup(this, farmerGroup);
            }
        }
    }

    @Subscribe
    public void onFetchUsersResponse(ArrayList<UserResponse> userResponses) {
        if (!userResponses.isEmpty() && userResponses.get(0) instanceof UserResponse) {
            for (UserResponse userResponse : userResponses) {
                User user = new User(userResponse.getUserID(), userResponse.getUserName()
                        , userResponse.getUserPassword(), userResponse.getUserType(), userResponse.getUserStatus(),
                        "");
                DataRepository.insertOrUpdateUser(this, user);
            }
        }
    }

    @Subscribe
    public void onFetchSeedsResponse(ArrayList<SeedResponse> seedResponses) {
        if (!seedResponses.isEmpty() && seedResponses.get(0) instanceof SeedResponse) {
            for (SeedResponse seedResponse : seedResponses) {
                Seed seed = new Seed(seedResponse.getSeedID(), seedResponse.getSeedRate(),
                        seedResponse.getSeedVariety(), seedResponse.getTransplantToHarvest(), seedResponse.getCropID());
                DataRepository.insertOrUpdateSeed(this, seed);
            }
        }
    }

    @Subscribe
    public void onFetchChemicalResponse(ArrayList<ChemicalResponse> chemicalResponses) {
        if (!chemicalResponses.isEmpty() && chemicalResponses.get(0) instanceof ChemicalResponse) {
            for (ChemicalResponse chemicalResponse : chemicalResponses) {
                Chemical chemical = new Chemical(chemicalResponse.getChemicalID(), chemicalResponse.getChemicalType(),
                        chemicalResponse.getCropStage(), chemicalResponse.getActiveIngredient(), chemicalResponse.getAgent(),
                        chemicalResponse.getManufacturer(), chemicalResponse.getPHI(), chemicalResponse.getProductTradeName(),
                        chemicalResponse.getRate(), chemicalResponse.getReasonForUse(), chemicalResponse.getRegistrationNumber());
                DataRepository.insertOrUpdateChemical(this, chemical);
            }
        }
    }

    @Subscribe
    public void onFetchFertilizerResponse(ArrayList<FertilizerResponse> fertilizerResponses) {
        if (!fertilizerResponses.isEmpty() && fertilizerResponses.get(0) instanceof FertilizerResponse) {

            for (FertilizerResponse fertilizerResponse : fertilizerResponses) {
                Fertilizer fertilizer = new Fertilizer(fertilizerResponse.getFertilizerID(), fertilizerResponse.getFertilizerType(),
                        fertilizerResponse.getMainNutrients(), fertilizerResponse.getSoilConditions(), fertilizerResponse.getTimeOfPlanting(),
                        fertilizerResponse.getTopDressing(), fertilizerResponse.getCropID());
                DataRepository.insertOrUpdateFertilizer(this, fertilizer);
            }
        }
    }

    @Subscribe
    public void onFetchPlantingSeasonsResponse(ArrayList<PlantingSeasonResponse> plantingSeasonResponses) {
        if (!plantingSeasonResponses.isEmpty() && plantingSeasonResponses.get(0) instanceof PlantingSeasonResponse) {
            for (PlantingSeasonResponse plantingSeasonResponse : plantingSeasonResponses) {
                PlantingSeason plantingSeason = new PlantingSeason(plantingSeasonResponse.getPlantingSeasonID(),
                        plantingSeasonResponse.getHarvestedQuantity(),
                        plantingSeasonResponse.getSeasonName(), plantingSeasonResponse.getStartDate(),
                        plantingSeasonResponse.getTargetDate(),
                        plantingSeasonResponse.getTargetQuantity(), plantingSeasonResponse.getCropID());
                DataRepository.insertOrUpdatePlantingSeason(this, plantingSeason);
            }
        }
    }


    @Subscribe
    public void onFetchCropsResponse(ArrayList<CropResponse> cropResponses) {
        if (!cropResponses.isEmpty() && cropResponses.get(0) instanceof CropResponse) {
            for (CropResponse cropResponse : cropResponses) {
                Crop crop = new Crop(cropResponse.getCropID(), cropResponse.getCropName(), cropResponse.getCropVariety());
                DataRepository.insertOrUpdateCrop(this, crop);
            }
        }
    }

    @Subscribe
    public void onFetchFarmersResponse(ArrayList<FarmerResponse> farmerResponses) {
        if (!farmerResponses.isEmpty() && farmerResponses.get(0) instanceof FarmerResponse) {
            for (FarmerResponse farmerResponse : farmerResponses) {
                Farmer farmer = new Farmer(farmerResponse.getFarmerID(), farmerResponse.getNames(),
                        farmerResponse.getNames(), farmerResponse.getTelephone(), farmerResponse.getAddress(),
                        farmerResponse.getGroupID());
                DataRepository.insertOrUpdateFarmer(this, farmer);
            }
        }
    }

    @Subscribe
    public void onFetchFieldsResponse(ArrayList<FieldResponse> fieldResponses) {
        if (!fieldResponses.isEmpty() && fieldResponses.get(0) instanceof FieldResponse) {
            for (FieldResponse fieldResponse : fieldResponses) {
                Field field = new Field(fieldResponse.getFieldID(), fieldResponse.getFieldName(),
                        fieldResponse.getLocation(), fieldResponse.getArea(),
                        fieldResponse.getFarmerID());
                DataRepository.insertOrUpdateField(this, field);
            }
        }
    }

    @Subscribe
    public void onFarmersSelectedEvent(Events.FarmersSelectedEvent event) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_view, new FarmerFragment()).
                setTransition(FragmentTransaction.TRANSIT_NONE).
                commit();
        setToolbarTransparent(false);
        this.toolbartitle.setText(R.string.farmers);
    }

    @Subscribe
    public void onDashboardSelectedEvent(Events.DashboardSelectedEvent event) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_view, new DashboardFragment()).
                setTransition(FragmentTransaction.TRANSIT_NONE).
                commit();
        setToolbarTransparent(false);
        this.toolbartitle.setText(R.string.dashboard);
    }

    @Subscribe
    public void onPlantingSeasonsSelectedEvent(Events.CropsSelectedEvent event) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_view, new PlantingSeasonFragment()).
                setTransition(FragmentTransaction.TRANSIT_NONE).
                commit();
        setToolbarTransparent(false);
        this.toolbartitle.setText(R.string.seasons);
    }

    @Subscribe
    public void onFarmInputsSelectedEvent(Events.FarmInputsSelectedEvent event) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_view, new FarmInputsFragment()).
                setTransition(FragmentTransaction.TRANSIT_NONE).
                commit();
        setToolbarTransparent(false);
        this.toolbartitle.setText(R.string.farminputs);
    }

    @Subscribe
    public void onCloseDrawerEvent(Events.CloseDrawerEvent event) {
        drawerLayout.closeDrawers();
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
            UiUtils.setStatusBarOneShadeDarker(getResources().getColor(R.color.primary_color), this);
            this.toolbar.setBackgroundColor(getResources().getColor(R.color.primary_color));
            this.setTitle("");
            this.toolbartitle.setText("Dashboard");
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mainContentView.getLayoutParams();
            params.setMargins(0, this.toolbar.getHeight() + 170, 0, 0);
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

