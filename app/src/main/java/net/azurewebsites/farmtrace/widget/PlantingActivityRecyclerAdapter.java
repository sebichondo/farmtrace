package net.azurewebsites.farmtrace.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingActivity;
import net.azurewebsites.farmtrace.utils.EnumUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 9/9/15.
 */
public class PlantingActivityRecyclerAdapter extends RecyclerView.Adapter<PlantingActivityRecyclerAdapter.CustomViewHolder> {

    private List<PlantingActivity> plantingActivityList;
    private Context mContext;

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(PlantingActivityRecyclerAdapter.CustomViewHolder holder, int position) {
        PlantingActivity plantingActivity = plantingActivityList.get(position);
        /*
        if(position < 10) {
            Picasso.with(mContext).load(resourceIds.get(position))
                    .into(holder.farmerImage);
        }
        /*

         */

        switch (plantingActivity.getActivityType()) {
            case EnumUtils.FarmingActivityType.Planting:
                holder.txtActivityType.setText("Activity Type : Planting" + " on " + plantingActivity.getActivityDate());
                break;
            case EnumUtils.FarmingActivityType.FertilizerApplication:
                holder.txtActivityType.setText("Activity Type : Fertilizer Application" + " on " + plantingActivity.getActivityDate());
                break;
            case EnumUtils.FarmingActivityType.CropProtection:
                holder.txtActivityType.setText("Activity Type : Crop Protection" + " on " + plantingActivity.getActivityDate());
                break;
        }
        holder.txtActivityInput.setText("Input : " + plantingActivity.getInput());
        holder.txtInputQuantity.setText("Quantity Applied : " + plantingActivity.getQuantity().toString());
    }


    public PlantingActivityRecyclerAdapter(Context context, List<PlantingActivity> plantingActivityList) {
        this.plantingActivityList = plantingActivityList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return (null != plantingActivityList ? plantingActivityList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.farm_description)
        TextView txtActivityType;
        @Bind(R.id.farmer_description)
        TextView txtActivityInput;
        @Bind(R.id.farmer_address)
        TextView txtInputQuantity;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.planting_activity_item, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }
}