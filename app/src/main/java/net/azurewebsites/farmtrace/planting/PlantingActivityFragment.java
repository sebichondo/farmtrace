package net.azurewebsites.farmtrace.planting;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.otto.Bus;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;
import net.azurewebsites.farmtrace.datamodel.dao.Fertilizer;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingActivity;
import net.azurewebsites.farmtrace.datamodel.dao.Seed;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.event.BusProvider;
import net.azurewebsites.farmtrace.event.Events;
import net.azurewebsites.farmtrace.utils.EnumUtils;
import net.azurewebsites.farmtrace.utils.FieldLocationManager;
import net.azurewebsites.farmtrace.utils.Settings;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    @Bind(R.id.btnSave)
    Button btnSave;
    @Bind(R.id.txtQuantityInput)
    EditText txtQuantity;

    protected final static String FIELD_ID = "FIELD_ID";
    protected final static String PLANTING_ACTIVITY_TYPE = "PLANTING_ACTIVITY_TYPE";

    private Long fieldID;
    private int plantingActivityTypeID;
    protected Bus bus = BusProvider.getInstance();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                Double appliedQuantity=Double.valueOf(txtQuantity.getText().toString());
                Location loc = FieldLocationManager.getInstance(getActivity()).getCurrentLocation();
                String sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                if(loc != null) {
                    PlantingActivity plantingActivity=new
                            PlantingActivity(null,plantingActivityTypeID,cboInputType.getSelectedItem().toString(),
                            appliedQuantity,(loc.getLatitude() + "," + loc.getLongitude()),sdate, Settings.getCurrentUser().getUserID(),fieldID);
                    DataRepository.insertOrUpdatePlantingActivity(getActivity(),plantingActivity);
                }
                else
                {
                    PlantingActivity plantingActivity=new
                            PlantingActivity(null,plantingActivityTypeID,cboInputType.getSelectedItem().toString(),
                            appliedQuantity,"unknown", sdate,Settings.getCurrentUser().getUserID(),fieldID);
                    DataRepository.insertOrUpdatePlantingActivity(getActivity(),plantingActivity);
                }
                bus.post(new Events.SaveButtonClickEvent());
                break;
        }
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

        btnSave.setOnClickListener(this);
        return v;
    }
}
