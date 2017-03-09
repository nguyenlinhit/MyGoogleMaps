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
import com.nguyenlinh.android.mygooglemaps.model.SmartPhone;

import java.util.List;

/**
 * Created by nguye on 3/9/2017.
 */

public class PhoneAdapter extends ArrayAdapter<SmartPhone> {
    Context context;
    int resource;
    List<SmartPhone> objects;
    public PhoneAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<SmartPhone> objects) {
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

        holder.txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
        final SmartPhone smartPhone = this.objects.get(position);
        holder.txtPhone.setText(smartPhone.getTen());

        return convertView;
    }

    private class ViewHolder{
        TextView txtPhone;
    }
}
