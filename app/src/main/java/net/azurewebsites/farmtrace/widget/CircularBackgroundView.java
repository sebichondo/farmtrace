package net.azurewebsites.farmtrace.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import net.azurewebsites.farmtrace.R;

/**
 * Created by sebichondo on 8/3/15.
 */
public class CircularBackgroundView extends View {
    int mColor;
    private int alpha = 255;

    public CircularBackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircularBackgroundView);
        mColor = a.getInt(R.styleable.CircularBackgroundView_circle_color, getResources().getColor(R.color.white));
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius;
        radius = getWidth() / 2;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(mColor);
        canvas.drawCircle(x / 2, y / 2, radius, paint);

    }

    public void setColor(int mColor) {
        this.mColor = mColor;
        invalidate();
        requestLayout();
    }
}