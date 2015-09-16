package net.azurewebsites.farmtrace.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;
import net.azurewebsites.farmtrace.datamodel.dao.Fertilizer;
import net.azurewebsites.farmtrace.datamodel.dao.Seed;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.widget.ChemicalRecyclerAdapter;
import net.azurewebsites.farmtrace.widget.FertilizerRecyclerAdapter;
import net.azurewebsites.farmtrace.widget.SeedRecyclerAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/26/15.
 */
public class FarmInputFragment extends Fragment {
    public static final int SEEDS = 1;
    public static final int CHEMICALS = 2;
    public static final int FERTILIZERS = 3;

    private static final String ARG_LIST_TYPE = "arg_list_type";

    private Context context;
    private int intInputType;

    @Bind(R.id.farm_inputs_recycler_view)
    RecyclerView rv;


    public static FarmInputFragment newInstance(int listType) {
        FarmInputFragment fragment = new FarmInputFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LIST_TYPE, listType);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farminput_list, container, false);
        ButterKnife.bind(this, view);

        intInputType = getArguments().getInt(ARG_LIST_TYPE, 0);
        List<Chemical> chemicalList = DataRepository.getAllChemicals(getActivity());
        List<Seed> seedList = DataRepository.getAllSeeds(getActivity());
        List<Fertilizer> fertilizerList = DataRepository.getAllFertilizers(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        switch (intInputType) {
            case 1:
                rv.setAdapter(new SeedRecyclerAdapter(seedList, getActivity()));
                break;
            case 2:
                rv.setAdapter(new ChemicalRecyclerAdapter(chemicalList, getActivity()));
                break;
            case 3:
                rv.setAdapter(new FertilizerRecyclerAdapter(fertilizerList, getActivity()));
                break;
        }

        return view;
    }
}
