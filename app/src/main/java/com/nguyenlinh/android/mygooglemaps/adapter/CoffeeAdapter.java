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
import com.nguyenlinh.android.mygooglemaps.model.Coffee;

import java.util.List;

/**
 * Created by nguye on 3/9/2017.
 *
 */

public class CoffeeAdapter extends ArrayAdapter<Coffee>{
    private Context context;
    private int resource;
    private List<Coffee> objects;
    public CoffeeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Coffee> objects) {
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

        holder.txtCoffee = (TextView) convertView.findViewById(R.id.txtCoffee);
        final Coffee coffee = this.objects.get(position);
        holder.txtCoffee.setText(coffee.getTen());
        return convertView;
    }

    private class ViewHolder{
        TextView txtCoffee;
    }
}
