package com.wmyeah.wmlauncher.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;

/**
 * 作者：ZhouYou
 * 日期：2016/8/29.
 */
public class Scale {

    private static int mDisplayWidth, mDisplayHeight;

    public static int dp2px(Context context, float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                value, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                value, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float value) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int getDisplayWidth(Activity activity) {
        if (mDisplayWidth == 0) {
            Point point = new Point();
            activity.getWindowManager().getDefaultDisplay().getSize(point);
            mDisplayWidth = point.x;
        }
        return mDisplayWidth;
    }

    public static int getDisplayHeight(Activity activity) {
        if (mDisplayHeight == 0) {
            Point point = new Point();
            activity.getWindowManager().getDefaultDisplay().getSize(point);
            mDisplayHeight = point.y;
        }
        return mDisplayHeight;
    }

}
