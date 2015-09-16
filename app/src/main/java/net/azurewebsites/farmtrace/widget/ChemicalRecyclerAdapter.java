package net.azurewebsites.farmtrace.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;
import net.azurewebsites.farmtrace.utils.EnumUtils;

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
            R.drawable.pirates
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

        switch (chemical.getChemicalType()) {
            case EnumUtils.ChemicalType.Fungicide:
                holder.farmDescription.setText(R.string.fungicide);
                break;
            case EnumUtils.ChemicalType.Insecticide:
                holder.farmDescription.setText(R.string.insecticide);
                break;
        }

        Log.d("MainActivity", "Active Ingredient" + chemical.getActiveIngredient());
        switch (chemical.getActiveIngredient()) {
            case EnumUtils.ChemicalActiveIngeredient.Acetamiprid:
                holder.farmerAddress.setText(R.string.acetamiprid);
                break;
            case EnumUtils.ChemicalActiveIngeredient.AlphaCrypermethrin:
                holder.farmerAddress.setText(R.string.alphaCrypermethrin);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Azadiraachtin:
                holder.farmerAddress.setText(R.string.azadiraachtin);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Azoxystrobin:
                holder.farmerAddress.setText(R.string.azoxystrobin);
                break;
            case EnumUtils.ChemicalActiveIngeredient.BacillusThuringiensis:
                holder.farmerAddress.setText(R.string.bacillusThuringiensis);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Carbendazim:
                holder.farmerAddress.setText(R.string.carbendazim);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Chlorothalonil:
                holder.farmerAddress.setText(R.string.chlorothalonil);
                break;
            case EnumUtils.ChemicalActiveIngeredient.CopperOxychloride:
                holder.farmerAddress.setText(R.string.copperOxychloride);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Cryromazine:
                holder.farmerAddress.setText(R.string.cryromazine);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Difenoconazole:
                holder.farmerAddress.setText(R.string.difenoconazole);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Imidacloprid:
                holder.farmerAddress.setText(R.string.imidacloprid);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Lambdacyhalothrin:
                holder.farmerAddress.setText(R.string.lambdacyhalothrin);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Manozeb:
                holder.farmerAddress.setText(R.string.manozeb);
                break;
            case EnumUtils.ChemicalActiveIngeredient.MonoDipotassiumPhosphates:
                holder.farmerAddress.setText(R.string.monoDipotassiumPhosphates);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Pyrethrins:
                holder.farmerAddress.setText(R.string.pyrethrins);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Spinosad:
                holder.farmerAddress.setText(R.string.spinosad);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Spiromesifen:
                holder.farmerAddress.setText(R.string.spiromesifen);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Sulphur:
                holder.farmerAddress.setText(R.string.sulphur);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Tebuconazole:
                holder.farmerAddress.setText(R.string.tebuconazole);
                break;
            case EnumUtils.ChemicalActiveIngeredient.Thiamethoxam:
                holder.farmerAddress.setText(R.string.thiamethoxam);
                break;

        }
        holder.farmerDescription.setText(chemical.getProductTradeName());
    }

    @Override
    public int getItemCount() {
        return (null != chemicalList ? chemicalList.size() : 0);
    }
}
