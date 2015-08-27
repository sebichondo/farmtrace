package net.azurewebsites.farmtrace.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Crop;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingSeason;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/25/15.
 */
public class SeasonRecyclerAdapter extends RecyclerView.Adapter<SeasonRecyclerAdapter.CustomViewHolder> {
    private List<PlantingSeason> plantingSeasonList;
    private Context mContext;
    List<Integer> resourceIds = Arrays.asList(
            R.drawable.weather
            );

    public SeasonRecyclerAdapter(List<PlantingSeason> plantingSeasonList, Context mContext) {
        this.plantingSeasonList = plantingSeasonList;
        this.mContext = mContext;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.farm_image)
        ImageView farmerImage;
        @Bind(R.id.farm_description)
        TextView farmDescription;
        @Bind(R.id.farmer_description)
        TextView farmerDescription;
        @Bind(R.id.farmer_address)
        TextView farmerAddress;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.farmer_item, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SeasonRecyclerAdapter.CustomViewHolder holder, int position) {
        PlantingSeason plantingSeason = plantingSeasonList.get(position);

        //Download image using picasso library
        Picasso.with(mContext).load(resourceIds.get(position))
                //.error(R.drawable.placeholder)
                // .placeholder(R.drawable.placeholder)
                .into(holder.farmerImage);

        holder.farmDescription.setText(plantingSeason.getSeasonName());
        holder.farmerAddress.setText(DateFormat.getDateInstance().format(plantingSeason.getStartDate()) + " - " + DateFormat.getDateInstance().format(plantingSeason.getTargetDate()) );
        Crop crop= DataRepository.getCropById(mContext, plantingSeason.getCropID());
        holder.farmerDescription.setText(crop.getCropName());

    }

    @Override
    public int getItemCount() {
        return (null != plantingSeasonList ? plantingSeasonList.size() : 0);
    }
}
