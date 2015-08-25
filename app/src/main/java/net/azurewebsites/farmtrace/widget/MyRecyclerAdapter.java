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
import net.azurewebsites.farmtrace.datamodel.dao.Field;
import net.azurewebsites.farmtrace.datamodel.repository.DataRepository;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/20/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {

    private List<Field> fieldItemList;
    private Context mContext;
    List<Integer> resourceIds = Arrays.asList(
            R.drawable.michaeljackson,
            R.drawable.female6,
            R.drawable.female1,
            R.drawable.female2,
            R.drawable.female5,
            R.drawable.female2,
            R.drawable.female8);

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.CustomViewHolder holder, int position) {
        Field fieldItem = fieldItemList.get(position);

        //Download image using picasso library
        Picasso.with(mContext).load(resourceIds.get(position))
                //.error(R.drawable.placeholder)
               // .placeholder(R.drawable.placeholder)
                .into(holder.farmerImage);
        holder.farmDescription.setText(fieldItem.getFieldName());
        Farmer farmer= DataRepository.getFarmerById(mContext,fieldItem.getFarmerID());
        holder.farmerDescription.setText(farmer.getNames());

    }

    public MyRecyclerAdapter(Context context, List<Field> fieldItemList) {
        this.fieldItemList = fieldItemList;
        this.mContext = context;

    }

    @Override
    public int getItemCount() {
        return (null != fieldItemList ? fieldItemList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.farm_image)
        ImageView farmerImage;
        @Bind(R.id.farm_description)
        TextView farmDescription;
        @Bind(R.id.farmer_description)
        TextView farmerDescription;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.farm_item, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }
}
