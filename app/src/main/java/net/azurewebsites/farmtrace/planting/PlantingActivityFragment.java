package net.azurewebsites.farmtrace.planting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;
import net.azurewebsites.farmtrace.datamodel.dao.Fertilizer;
import net.azurewebsites.farmtrace.datamodel.dao.Seed;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.utils.EnumUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 9/8/15.
 */
public class PlantingActivityFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.txtFarmInput)
    TextView farmInput;
    @Bind(R.id.cboInputType)
    Spinner cboInputType;

    protected final static String FIELD_ID = "FIELD_ID";
    protected final static String PLANTING_ACTIVITY_TYPE = "PLANTING_ACTIVITY_TYPE";

    private Long fieldID;
    private int plantingActivityTypeID;

    @Override
    public void onClick(View v) {

    }

    public static PlantingActivityFragment newInstance(Long fieldID,int plantingActivityTypeID) {
        PlantingActivityFragment fragment = new PlantingActivityFragment();
        Bundle args = new Bundle();
        args.putLong(FIELD_ID, fieldID);
        args.putInt(PLANTING_ACTIVITY_TYPE, plantingActivityTypeID);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planting_activity, container, false);
        ButterKnife.bind(this, v);


        fieldID = getArguments().getLong(FIELD_ID);
        plantingActivityTypeID = getArguments().getInt(PLANTING_ACTIVITY_TYPE);

        Log.d("DataRepository", "The Number of Fields Inserted: " + plantingActivityTypeID);
        switch (plantingActivityTypeID) {
            case EnumUtils.FarmingActivityType.Planting:
                farmInput.setText(R.string.seeds);
                List<Seed> seedList= DataRepository.getAllSeeds(getActivity());
                ArrayAdapter<Seed> adapter=new ArrayAdapter<Seed>(getActivity(),android.R.layout.simple_list_item_1,seedList);
                cboInputType.setAdapter(adapter);
                break;
            case EnumUtils.FarmingActivityType.FertilizerApplication:
                farmInput.setText(R.string.fertilizers);
                List<Fertilizer> fertilizerList= DataRepository.getAllFertilizers(getActivity());
                ArrayAdapter<Fertilizer> fertilizerArrayAdapteradapter=new ArrayAdapter<Fertilizer>(getActivity(),android.R.layout.simple_list_item_1,fertilizerList);
                cboInputType.setAdapter(fertilizerArrayAdapteradapter);
                break;
            case EnumUtils.FarmingActivityType.CropProtection:
                farmInput.setText(R.string.chemicals);
                List<Chemical> chemicalList= DataRepository.getAllChemicals(getActivity());
                ArrayAdapter<Chemical> chemicalArrayAdapter=new ArrayAdapter<Chemical>(getActivity(),android.R.layout.simple_list_item_1,chemicalList);
                cboInputType.setAdapter(chemicalArrayAdapter);
                break;
        }

        return v;
    }
}
