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
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.widget.FarmerRecyclerAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/24/15.
 */
public class FarmerFragment extends Fragment implements View.OnClickListener {
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
        List<Farmer> farmers = DataRepository.getAllFarmers(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new FarmerRecyclerAdapter(getActivity(), farmers));
        return view;
    }
}
