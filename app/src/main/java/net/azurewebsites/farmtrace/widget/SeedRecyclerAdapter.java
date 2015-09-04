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
import net.azurewebsites.farmtrace.datamodel.dao.Seed;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/26/15.
 */
public class SeedRecyclerAdapter extends RecyclerView.Adapter<SeedRecyclerAdapter.CustomViewHolder> {
    private List<Seed> seedList;
    private Context mContext;
    List<Integer> resourceIds = Arrays.asList(
            R.drawable.seed
    );

    public SeedRecyclerAdapter(List<Seed> seedList, Context mContext) {
        this.seedList = seedList;
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
    public void onBindViewHolder(SeedRecyclerAdapter.CustomViewHolder holder, int position) {
        Seed seed = seedList.get(position);

        //Download image using picasso library
        Picasso.with(mContext).load(resourceIds.get(0))
                .into(holder.farmerImage);

        holder.farmDescription.setText("Variety : " + seed.getSeedVariety());
        holder.farmerAddress.setText("Transplant to Harvest : " + seed.getTransplantToHarvest() + " Days");
        Crop crop= DataRepository.getCropById(mContext, seed.getCropID());
        holder.farmerDescription.setText("Crop : " + crop.getCropName());

    }

    @Override
    public int getItemCount() {
        return (null != seedList ? seedList.size() : 0);
    }
}
