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

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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
        String sdate = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.getDefault()).format(plantingActivity.getActivityDate());

        switch (plantingActivity.getActivityType()) {
            case EnumUtils.FarmingActivityType.Planting:
                holder.txtActivityType.setText(sdate);
                holder.txtImageText.setText("P");
                holder.txtImageText.setBackgroundResource(R.drawable.blue_circle);
                break;
            case EnumUtils.FarmingActivityType.FertilizerApplication:
                holder.txtActivityType.setText(sdate);
                holder.txtImageText.setText("F");
                holder.txtImageText.setBackgroundResource(R.drawable.purple_circle);
                break;
            case EnumUtils.FarmingActivityType.CropProtection:
                holder.txtActivityType.setText(sdate);
                holder.txtImageText.setText("C");
                break;
        }
        holder.txtActivityInput.setText("Input : " + plantingActivity.getInput());
        holder.txtInputQuantity.setText("Quantity Applied : " + plantingActivity.getQuantity().toString() + " Kg");
    }


    public PlantingActivityRecyclerAdapter(Context context, List<PlantingActivity> plantingActivityList) {
        this.plantingActivityList = plantingActivityList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return (null != plantingActivityList ? plantingActivityList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.farm_description)
        TextView txtActivityType;
        @Bind(R.id.farmer_description)
        TextView txtActivityInput;
        @Bind(R.id.farmer_address)
        TextView txtInputQuantity;
        @Bind(R.id.txtImageText)
        TextView txtImageText;

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
