package com.onistech.user.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onistech.user.model.DataModel;
import com.onistech.user.moranmandi.R;

/**
 * Created by user on 3/19/2018.
 */

public class DrawerListAdapter extends ArrayAdapter<DataModel> {
    Context context;
    int resource;
    DataModel[] data = null;

    public DrawerListAdapter(@NonNull Context context, @LayoutRes int resource, DataModel[] data) {
        super(context, resource,data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItem = inflater.inflate(R.layout.list_view_item_row,parent,false);
        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        DataModel folder = data[position];
        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);
        return listItem;
    }
}
