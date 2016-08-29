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

import java.util.List;

public class MainActivity extends Activity {

    private List<ResolveInfo> apps;

    private GridView gv;

    private DisplayMetrics dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dm = getResources().getDisplayMetrics();
        loadApps();
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.apps_list);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dm.heightPixels - 200);
//        gv.setLayoutParams(layoutParams);
        AppsAdapter adapter = new AppsAdapter(this, apps);
        gv.setAdapter(adapter);
    }


    private void loadApps() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        apps = getPackageManager().queryIntentActivities(mainIntent, 0);
    }


    public static class AppsAdapter extends BaseAdapter {

        private Context context;

        private List<ResolveInfo> data;

        public AppsAdapter(Context context, List<ResolveInfo> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public ResolveInfo getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.item_view, null);
                holder.ivApp = (ImageView) convertView.findViewById(R.id.iv_app);
                holder.tvApp = (TextView) convertView.findViewById(R.id.tv_app);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ResolveInfo resolveInfo = getItem(position);

            ActivityInfo activityInfo = resolveInfo.activityInfo;
            holder.ivApp.setImageDrawable(activityInfo.loadIcon(context.getPackageManager()));
            holder.tvApp.setText(activityInfo.loadLabel(context.getPackageManager()));

            return convertView;
        }

        class ViewHolder {
            ImageView ivApp;
            TextView tvApp;
        }
    }


}
