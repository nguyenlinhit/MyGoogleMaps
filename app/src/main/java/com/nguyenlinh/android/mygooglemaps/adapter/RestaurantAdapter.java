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
import com.nguyenlinh.android.mygooglemaps.model.Restaurant;

import java.util.List;

/**
 * Created by nguye on 3/9/2017.
 * Adapter Restaurant
 */

public class RestaurantAdapter  extends ArrayAdapter<Restaurant>{
    Context context;
    int resource;
    List<Restaurant> objects;
    public RestaurantAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Restaurant> objects) {
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
        holder.txtRestaurant = (TextView) convertView.findViewById(R.id.txtRestaurant);

        final Restaurant restaurant = this.objects.get(position);
        holder.txtRestaurant.setText(restaurant.getTen());

        return convertView;
    }

    private class ViewHolder{
        TextView txtRestaurant;
    }
}
