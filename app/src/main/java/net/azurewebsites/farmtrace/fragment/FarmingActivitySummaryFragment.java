package net.azurewebsites.farmtrace.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.squareup.otto.Bus;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingActivity;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.event.BusProvider;
import net.azurewebsites.farmtrace.event.Events;
import net.azurewebsites.farmtrace.widget.PlantingActivityRecyclerAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 9/3/15.
 */
public class FarmingActivitySummaryFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.farming_activity_recycler_view)
    RecyclerView rv;
    @Bind(R.id.farm_activity_description)
    TextView farmerDescription;
    @Bind(R.id.multiple_actions_down)
    FloatingActionsMenu plusButton;

    protected final static String FIELD_ID = "FIELD_ID";
    protected final static String FIELD_DESC = "FIELD_DESC";
    protected final static String FARMER_DESC = "FARMER_DESC";

    private Long fieldID;
    private boolean fabMenuExapnded = false;
    protected Bus bus = BusProvider.getInstance();

    private String farmDescription;

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public static FarmingActivitySummaryFragment newInstance(Long fieldID,String fieldDesc,String farmerDesc) {
        FarmingActivitySummaryFragment fragment = new FarmingActivitySummaryFragment();
        Bundle args = new Bundle();
        args.putLong(FIELD_ID, fieldID);
        args.putString(FIELD_DESC, fieldDesc);
        args.putString(FARMER_DESC, farmerDesc);
        fragment.setArguments(args);
        return fragment;
    }


    public static void setFabMenuBackground(final Context context, final Bus bus, final FloatingActionsMenu plusButton) {

        plusButton.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                bus.post(new Events.FabButtonClickEvent(plusButton.isExpanded()));
                Log.d("Farming Dashboard", "MENU EXPANDED");
                plusButton.collapse();
            }

            @Override
            public void onMenuCollapsed() {
                //bus.post(new Events.FabButtonClickEvent(plusButton.isExpanded()));
                Log.d("Farming Dashboard", "MENU COLLAPSED");
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Farming Dashboard", "MENU COLLAPSED ON ACTIVITY RESULT");
    }

    private void updateUI(){
        List<PlantingActivity> plantingActivities= DataRepository.getAllPlantingActivityByFieldId(getActivity(), fieldID);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new PlantingActivityRecyclerAdapter(getActivity(), plantingActivities));
    }
    @Override
    public void onClick(View v) {
        Log.d("Farming Dashboard", "Just got CLICKED YOU Type");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farming_activity, container, false);
        ButterKnife.bind(this, view);
        farmDescription = getArguments().getString(FIELD_DESC) + " - " + getArguments().getString(FARMER_DESC);
        farmerDescription.setText(farmDescription);
        fieldID = getArguments().getLong(FIELD_ID);
        plusButton.setOnClickListener(this);
        setFabMenuBackground(getActivity(), bus, plusButton);
        updateUI();
        return view;
    }
}
