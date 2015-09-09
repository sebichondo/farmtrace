package net.azurewebsites.farmtrace.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.dao.Field;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;
import net.azurewebsites.farmtrace.farmingactivity.FarmingDashboardActivity;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/20/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
    private List<Field> fieldItemList;
    private String fieldDesc;
    private String farmerDesc;
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

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.CustomViewHolder holder, int position) {
        Field fieldItem = fieldItemList.get(position);
        DecimalFormat f = new DecimalFormat("##.000");
        Double ha=fieldItem.getArea()/10000;
        //Download image using picasso library

        if(position < 10) {
            Picasso.with(mContext).load(resourceIds.get(position))
                    .into(holder.farmerImage);
        }

        holder.farmDescription.setText("Field : " + fieldItem.getFieldName());
        Farmer farmer= DataRepository.getFarmerById(mContext,fieldItem.getFarmerID());
        holder.farmerDescription.setText("Farmer : " + farmer.getNames());
        holder.farmerAddress.setText("Field Size : " + f.format(ha) + " Ha");
    }


    public MyRecyclerAdapter(Context context, List<Field> fieldItemList) {
        this.fieldItemList = fieldItemList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return (null != fieldItemList ? fieldItemList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            fieldDesc= farmDescription.getText().toString();
            farmerDesc=farmerDescription.getText().toString();
            Intent intent=FarmingDashboardActivity.newInstance(v.getContext(), fieldDesc, farmerDesc);
            v.getContext().startActivity (intent);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.farmer_item, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }
}
