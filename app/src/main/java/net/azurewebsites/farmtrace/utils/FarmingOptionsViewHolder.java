package net.azurewebsites.farmtrace.utils;

import android.view.View;
import android.widget.TextView;

import net.azurewebsites.farmtrace.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 9/5/15.
 */
public class FarmingOptionsViewHolder {
    @Bind(R.id.farming_activity)
    TextView farmingActivityTextView;

    public FarmingOptionsViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setFarmingActivityText(String text) {
        farmingActivityTextView.setText(text);
    }
}
