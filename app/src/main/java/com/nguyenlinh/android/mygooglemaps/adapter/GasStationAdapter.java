package com.nguyenlinh.android.mygooglemaps.adapter;

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
import com.nguyenlinh.android.mygooglemaps.model.GasStation;

import java.util.List;

/**
 * Created by nguye on 3/9/2017.
 *
 */

public class GasStationAdapter extends ArrayAdapter<GasStation> {
    Context context;
    int resource;
    List<GasStation> objects;
    public GasStationAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<GasStation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(this.resource,null);
        ViewHolder holder = new ViewHolder();

        holder.txtGas = (TextView) convertView.findViewById(R.id.txtGas);
        final GasStation gasStation = this.objects.get(position);
        holder.txtGas.setText(gasStation.getTen());
        return convertView;
    }

    private class ViewHolder{
        TextView txtGas;
    }
}
