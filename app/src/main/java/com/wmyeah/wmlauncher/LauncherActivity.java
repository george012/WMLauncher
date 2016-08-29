package com.wmyeah.wmlauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wmyeah.wmlauncher.base.App;
import com.wmyeah.wmlauncher.desktop.AppAdapter;

import java.util.List;

public class LauncherActivity extends Activity {

    private List<ResolveInfo> apps;

    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apps = App.get().getAppsOnDesktop();
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.apps_list);
        AppAdapter adapter = new AppAdapter(this, apps);
        gv.setAdapter(adapter);
    }
}
