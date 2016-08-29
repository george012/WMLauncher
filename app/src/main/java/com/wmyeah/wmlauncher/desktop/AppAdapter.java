package com.wmyeah.wmlauncher.desktop;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wmyeah.wmlauncher.R;
import com.wmyeah.wmlauncher.utils.ListUtils;

import java.util.List;

/**
 * 作者：ZhouYou
 * 日期：2016/8/29.
 */
public class AppAdapter extends BaseAdapter {
    private Context context;

    private List<ResolveInfo> data;

    public AppAdapter(Context context, List<ResolveInfo> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return ListUtils.getCount(data);
    }

    @Override
    public ResolveInfo getItem(int position) {
        return ListUtils.getElement(data, position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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

    static class ViewHolder {
        ImageView ivApp;
        TextView tvApp;
    }
}
