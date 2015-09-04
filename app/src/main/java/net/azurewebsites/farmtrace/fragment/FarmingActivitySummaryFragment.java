package net.azurewebsites.farmtrace.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.widget.FarmerRecyclerAdapter;

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

    protected final static String FIELD_DESC = "FIELD_DESC";
    protected final static String FARMER_DESC = "FARMER_DESC";

    private String farmDescription;


    public static FarmingActivitySummaryFragment newInstance(String fieldDesc,String farmerDesc) {
        FarmingActivitySummaryFragment fragment = new FarmingActivitySummaryFragment();
        Bundle args = new Bundle();
        args.putString(FIELD_DESC, fieldDesc);
        args.putString(FARMER_DESC, farmerDesc);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onClick(View v) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farming_activity, container, false);
        ButterKnife.bind(this, view);
        farmDescription = "Field : " + getArguments().getString(FIELD_DESC) + " - Farmer : " + getArguments().getString(FARMER_DESC);
        farmerDescription.setText(farmDescription);
        List<Farmer> farmers= DataRepository.getAllFarmers(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new FarmerRecyclerAdapter(getActivity(), farmers));
        return view;
    }
}
