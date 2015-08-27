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
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/26/15.
 */
public class ChemicalRecyclerAdapter extends RecyclerView.Adapter<ChemicalRecyclerAdapter.CustomViewHolder> {
    private List<Chemical> chemicalList;
    private Context mContext;
    List<Integer> resourceIds = Arrays.asList(
            R.drawable.truck
    );

    public ChemicalRecyclerAdapter(List<Chemical> chemicalList, Context mContext) {
        this.chemicalList = chemicalList;
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
    public void onBindViewHolder(ChemicalRecyclerAdapter.CustomViewHolder holder, int position) {
        Chemical chemical = chemicalList.get(position);

        //Download image using picasso library
        Picasso.with(mContext).load(resourceIds.get(0))
                .into(holder.farmerImage);

        holder.farmDescription.setText(chemical.getProductTradeName());
        holder.farmerDescription.setText(chemical.getManufacturer());
    }

    @Override
    public int getItemCount() {
        return (null != chemicalList ? chemicalList.size() : 0);
    }
}
