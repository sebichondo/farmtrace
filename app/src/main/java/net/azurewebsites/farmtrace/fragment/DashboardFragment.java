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
import net.azurewebsites.farmtrace.datamodel.dao.Field;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.widget.MyRecyclerAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/24/15.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.farm_list_recycler_view)
    RecyclerView rv;

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fields_list, container, false);
        ButterKnife.bind(this, view);
        //fields
        List<Field> fields = DataRepository.getAllFields(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new MyRecyclerAdapter(getActivity(), fields));
        return view;
    }
}
