package net.azurewebsites.farmtrace.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;

/**
 * Created by sebichondo on 8/5/15.
 */
public class UiUtils {

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
}
