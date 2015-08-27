package net.azurewebsites.farmtrace.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingSeason;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.widget.SeasonRecyclerAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/25/15.
 */
public class PlantingSeasonFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.farmer_list_recycler_view)
    RecyclerView rv;

    @Override
    public void onClick(View v) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farmer, container, false);
        ButterKnife.bind(this, view);
        //fields
        List<PlantingSeason> plantingSeasonList= DataRepository.getAllPlantingSeasons(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new SeasonRecyclerAdapter(plantingSeasonList,getActivity()));
        return view;
    }
}
