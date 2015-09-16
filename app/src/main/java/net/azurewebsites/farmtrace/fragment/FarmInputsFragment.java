package net.azurewebsites.farmtrace.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import net.azurewebsites.farmtrace.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sebichondo on 8/25/15.
 */
public class FarmInputsFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @Bind(R.id.pager)
    ViewPager viewPager;

    private int type;
    private FarmInputsListPagerAdapter pagerAdapter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farm_inputs, container, false);
        ButterKnife.bind(this, view);

        String[] pagetitles = new String[]{
                getString(R.string.seeds), getString(R.string.chemicals),
                getString(R.string.fertilizers)
        };

        pagerAdapter = new FarmInputsListPagerAdapter(getActivity().getSupportFragmentManager(), pagetitles);

        viewPager.setAdapter(pagerAdapter);
        tabs.setViewPager(viewPager);
        Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/kontrapunkt_light.otf");
        tabs.setTypeface(typeFace, Typeface.NORMAL);

        return view;
    }

    public class FarmInputsListPagerAdapter extends FragmentStatePagerAdapter {
        String[] pageTitles;

        public FarmInputsListPagerAdapter(FragmentManager fm, String[] pageTitles) {
            super(fm);
            this.pageTitles = pageTitles;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    type = FarmInputFragment.SEEDS;
                    break;
                case 1:
                    type = FarmInputFragment.CHEMICALS;
                    break;
                case 2:
                    type = FarmInputFragment.FERTILIZERS;
                    break;

            }

            Fragment fragment = FarmInputFragment.newInstance(type);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return pageTitles[0];//getString(R.string.tab_title_recent);
                case 1:
                    return pageTitles[1];//getString(R.string.tab_title_favorites);
                case 2:
                    return pageTitles[2];//getString(R.string.tab_title_all);
            }

            return "";
        }


        @Override
        public int getCount() {
            return pageTitles.length;
        }
    }
}
