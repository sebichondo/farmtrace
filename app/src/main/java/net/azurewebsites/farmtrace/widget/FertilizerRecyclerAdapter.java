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
import net.azurewebsites.farmtrace.datamodel.dao.Fertilizer;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.utils.EnumUtils;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/26/15.
 */
public class FertilizerRecyclerAdapter extends RecyclerView.Adapter<FertilizerRecyclerAdapter.CustomViewHolder> {
    private List<Fertilizer> fertilizerList;
    private Context mContext;
    List<Integer> resourceIds = Arrays.asList(
            R.drawable.fertilizer
    );

    public FertilizerRecyclerAdapter(List<Fertilizer> fertilizerList, Context mContext) {
        this.fertilizerList = fertilizerList;
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
    public void onBindViewHolder(FertilizerRecyclerAdapter.CustomViewHolder holder, int position) {
        Fertilizer fertilizer = fertilizerList.get(position);

        //Download image using picasso library
        Picasso.with(mContext).load(resourceIds.get(0))
                .into(holder.farmerImage);

        switch(fertilizer.getFertilizerType()){
            case EnumUtils.FertilizerType.Anyhdrous:
                holder.farmDescription.setText(R.string.anyhdrous);
                break;
            case EnumUtils.FertilizerType.Dry:
                holder.farmDescription.setText(R.string.dry);
                break;
            case EnumUtils.FertilizerType.Liquid:
                holder.farmDescription.setText(R.string.liquid);
                break;
            case EnumUtils.FertilizerType.Micronutrients:
                holder.farmDescription.setText(R.string.micronutrients);
                break;
        }

        switch(fertilizer.getMainNutrients()){
            case EnumUtils.FertilizerNutrientType.NPK:
                holder.farmerAddress.setText(R.string.NPK);
                break;
            case EnumUtils.FertilizerNutrientType.ASN:
                holder.farmerAddress.setText(R.string.ASN);
                break;
            case EnumUtils.FertilizerNutrientType.CAN:
                holder.farmerAddress.setText(R.string.CAN);
                break;
            case EnumUtils.FertilizerNutrientType.DAP:
                holder.farmerAddress.setText(R.string.DAP);
                break;
            case EnumUtils.FertilizerNutrientType.TSP:
                holder.farmerAddress.setText(R.string.TSP);
                break;
        }

        Crop crop= DataRepository.getCropById(mContext, fertilizer.getCropID());
        holder.farmerDescription.setText(crop.getCropName());

    }

    @Override
    public int getItemCount() {
        return (null != fertilizerList ? fertilizerList.size() : 0);
    }
}