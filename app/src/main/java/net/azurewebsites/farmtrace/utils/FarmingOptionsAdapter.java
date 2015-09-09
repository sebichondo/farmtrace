package net.azurewebsites.farmtrace.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.azurewebsites.farmtrace.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebichondo on 9/5/15.
 */
public class FarmingOptionsAdapter extends BaseAdapter {
    private final List<FarmingActivityOption> mData = new ArrayList<FarmingActivityOption>() {{
        add(new FarmingActivityOption( "Planting"));
        add(new FarmingActivityOption( "Fertilizer Application"));
        add(new FarmingActivityOption( "Crop Protection"));
    }};

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public FarmingActivityOption getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FarmingActivityOption option = getItem(position);
        FarmingOptionsViewHolder viewHolder;
        if (null == convertView) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.destination_row_item, parent, false);
            viewHolder = new FarmingOptionsViewHolder(convertView);
            convertView.setTag(viewHolder);
            viewHolder.setFarmingActivityText(option.getFarmingActivityName());
        }

        return convertView;
    }
}
