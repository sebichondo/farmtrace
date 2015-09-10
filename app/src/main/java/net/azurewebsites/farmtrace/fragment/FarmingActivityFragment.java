package net.azurewebsites.farmtrace.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.azurewebsites.farmtrace.Constants;
import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.planting.PlantingActivity;
import net.azurewebsites.farmtrace.utils.EnumUtils;
import net.azurewebsites.farmtrace.utils.FarmingOptionsAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by sebichondo on 9/5/15.
 */
public class FarmingActivityFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.farming_activity_options)
    ListView farmingOptionsListView;

    private Long fieldID;
    protected final static String FIELD_DESC = "FIELD_DESC";
    protected final static String FARMER_DESC = "FARMER_DESC";
    protected final static String FIELD_ID = "FIELD_ID";


    @Override
    public void onClick(View v) {

    }

    public static FarmingActivityFragment newInstance(Long fieldID,String fieldDesc, String farmerDesc) {
        FarmingActivityFragment fragment = new FarmingActivityFragment();
        Bundle args = new Bundle();
        args.putLong(FIELD_ID, fieldID);
        args.putString(FIELD_DESC, fieldDesc);
        args.putString(FARMER_DESC, farmerDesc);
        fragment.setArguments(args);
        return fragment;
    }

    @OnItemClick(R.id.farming_activity_options)
    public void onPaymentOptionClicked(int position) {
        int sendTo;
        switch (position) {
            case EnumUtils.FarmingActivityType.Planting:
                getActivity().startActivityForResult(PlantingActivity.newInstance(getActivity(), fieldID,position), Constants.PLANTING_ACTIVITY_CODE);
                break;
            case EnumUtils.FarmingActivityType.FertilizerApplication:
                getActivity().startActivityForResult(PlantingActivity.newInstance(getActivity(), fieldID, position), Constants.PLANTING_ACTIVITY_CODE);
                break;
            case EnumUtils.FarmingActivityType.Irrigation:
                getActivity().startActivityForResult(PlantingActivity.newInstance(getActivity(), fieldID, position), Constants.PLANTING_ACTIVITY_CODE);
                break;
            case EnumUtils.FarmingActivityType.CropProtection:
                getActivity().startActivityForResult(PlantingActivity.newInstance(getActivity(), fieldID, position), Constants.PLANTING_ACTIVITY_CODE);
                break;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        farmingOptionsListView.setAdapter(new FarmingOptionsAdapter());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_farming_activity_chooser, container, false);
        ButterKnife.bind(this, v);
        fieldID = getArguments().getLong(FIELD_ID);
        return v;
    }
}
