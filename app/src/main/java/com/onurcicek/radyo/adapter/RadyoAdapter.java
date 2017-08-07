package com.onurcicek.radyo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.onurcicek.radyo.R;
import com.onurcicek.radyo.app.AppController;
import com.onurcicek.radyo.model.Radyo;

import java.util.List;

/**
 * Created by plox on 10.12.2016.
 */

public class RadyoAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Radyo> radyoItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public RadyoAdapter(Activity activity, List<Radyo> radyoItems) {
        this.activity = activity;
        this.radyoItems = radyoItems;
    }

    @Override
    public int getCount() {
        return radyoItems.size();
    }

    @Override
    public Object getItem(int location) {
        return radyoItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_radyo, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView radyo_fotograf = (NetworkImageView) convertView.findViewById(R.id.radyofotograf);
        TextView radyo_isim = (TextView) convertView.findViewById(R.id.radyoismi);

        Radyo r = radyoItems.get(position);

        radyo_fotograf.setImageUrl(r.getRadyofotograf(), imageLoader);

        radyo_isim.setText(r.getRadyoismi());


        return convertView;
    }

}
