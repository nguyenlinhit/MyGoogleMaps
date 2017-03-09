package com.nguyenlinh.android.mygooglemaps.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nguyenlinh.android.mygooglemaps.app.R;
import com.nguyenlinh.android.mygooglemaps.fragment.HotelFragment;
import com.nguyenlinh.android.mygooglemaps.model.Hotel;

import java.util.List;


public class HotelAdapter extends ArrayAdapter<Hotel> {

    Context context;
    int resource;
    List<Hotel> objects;

    public HotelAdapter(Context context, int resource, List<Hotel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater inflater = this.context.getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View r = inflater.inflate(this.resource,null);

        ViewHolder holder = new ViewHolder();
        holder.txtHotel = (TextView) r.findViewById(R.id.txtHotel);

        final Hotel hotel = this.objects.get(position);
        holder.txtHotel.setText(hotel.getTen());

        return r;
    }

    private static class ViewHolder{
        TextView txtHotel;
    }
}
