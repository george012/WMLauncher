package com.wmyeah.wmlauncher.base;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ResolveInfo;

import com.wmyeah.wmlauncher.utils.ListUtils;

import java.util.List;

/**
 * 作者：ZhouYou
 * 日期：2016/8/29.
 */
public class App extends Application {

    private static App instance;

    public static App get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private List<ResolveInfo> mApps;

    public List<ResolveInfo> getAppsOnDesktop() {
        if (mApps == null || mApps.size() <= 0) {
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            mApps = getPackageManager().queryIntentActivities(mainIntent, 0);
        }
        return mApps;
    }

    public int getAppsOnDesktopNumber() {
        List<ResolveInfo> data = getAppsOnDesktop();
        if (ListUtils.getCount(data) <= 0) return 0;
        return data.size();
    }
}
