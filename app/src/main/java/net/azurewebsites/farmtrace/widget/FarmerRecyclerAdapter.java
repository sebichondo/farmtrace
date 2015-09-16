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
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroup;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/25/15.
 */
public class FarmerRecyclerAdapter extends RecyclerView.Adapter<FarmerRecyclerAdapter.CustomViewHolder> {
    private List<Farmer> farmerList;
    private Context mContext;
    List<Integer> resourceIds = Arrays.asList(
            R.drawable.michaeljackson,
            R.drawable.female6,
            R.drawable.female1,
            R.drawable.female2,
            R.drawable.female5,
            R.drawable.female2,
            R.drawable.female8,
            R.drawable.female7,
            R.drawable.female9,
            R.drawable.male5);

    public FarmerRecyclerAdapter(Context context, List<Farmer> farmerList) {
        this.farmerList = farmerList;
        this.mContext = context;
    }

    @Override
    public void onBindViewHolder(FarmerRecyclerAdapter.CustomViewHolder holder, int position) {
        Farmer farmer = farmerList.get(position);

        //Download image using picasso library
        if (position < 10) {
            Picasso.with(mContext).load(resourceIds.get(position))
                    .into(holder.farmerImage);
        }

        holder.farmDescription.setText(farmer.getNames());
        holder.farmerAddress.setText(farmer.getTelephone());
        FarmerGroup farmerGroup = DataRepository.getGroupById(mContext, farmer.getFarmerGroupID());
        holder.farmerDescription.setText(farmerGroup.getGroupName() + " Group");
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
    public int getItemCount() {
        return (null != farmerList ? farmerList.size() : 0);
    }

}
