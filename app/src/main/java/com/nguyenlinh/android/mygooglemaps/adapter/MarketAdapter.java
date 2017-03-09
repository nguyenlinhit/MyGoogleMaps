package com.nguyenlinh.android.mygooglemaps.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nguyenlinh.android.mygooglemaps.app.R;
import com.nguyenlinh.android.mygooglemaps.model.Market;

import java.util.List;

/**
 * Created by nguye on 3/9/2017.
 * Market Adapter
 */

public class MarketAdapter extends ArrayAdapter<Market> {
    Context context;
    int resource;
    List<Market> objects;
    public MarketAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Market> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(this.resource,null);
        ViewHolder holder = new ViewHolder();
        holder.txtMarket = (TextView) convertView.findViewById(R.id.txtMarket);
        final Market market = this.objects.get(position);
        holder.txtMarket.setText(market.getTen());


        return convertView;
    }

    private class ViewHolder{
        TextView txtMarket;
    }
}
