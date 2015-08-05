package net.azurewebsites.farmtrace.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;

/**
 * Created by sebichondo on 8/5/15.
 */
public class UiUtils{

    public static void setStatusBarColor(int color, Activity context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // make the color darker for statusbar
            context.getWindow().setStatusBarColor(color);
        }
    }

    public static void setStatusBarOneShadeDarker(int color, Activity context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // make the color darker for statusbar
            context.getWindow().setStatusBarColor(getDarkerTone(color));
        }
    }

    public static int getDarkerTone(int color) {

        float[] hsv = new float[3];

        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        int darker = Color.HSVToColor(hsv);

        return darker;
    }

    /*
    public static void setFabMenuBackground(final Context context, final Bus bus, final FloatingActionsMenu plusButton, final View opaqueBackground) {

        plusButton.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                Animation in = AnimationUtils.loadAnimation(context, R.anim.fadein);
                bus.post(new Events.FabButtonClickEvent(plusButton.isExpanded()));
                opaqueBackground.startAnimation(in);

                in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        opaqueBackground.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }

            @Override
            public void onMenuCollapsed() {
                Animation out = AnimationUtils.loadAnimation(context, R.anim.fadeout);
                opaqueBackground.startAnimation(out);
                bus.post(new Events.FabButtonClickEvent(plusButton.isExpanded()));
            }
        });
    }*/

}
