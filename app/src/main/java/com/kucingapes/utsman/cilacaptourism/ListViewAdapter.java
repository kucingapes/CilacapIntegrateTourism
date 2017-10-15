package com.kucingapes.utsman.cilacaptourism;

/**
 * Created by Dharma on 10/15/2017.
 */


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends ArrayAdapter<String> {

    private MainActivity activity;
    private List<String> objekList;
    private List<String> searchList;

    public ListViewAdapter(MainActivity context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.objekList = objects;
        this.searchList = new ArrayList<>();
        this.searchList.addAll(objekList);
    }

    @Override
    public int getCount() {
        return objekList.size();
    }

    @Override
    public String getItem(int position) {
        return objekList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.objekName.setText(getItem(position));

        return convertView;
    }

    // Filter method
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        objekList.clear();
        if (charText.length() == 0) {
            objekList.addAll(searchList);
        } else {
            for (String s : searchList) {
                if (s.toLowerCase(Locale.getDefault()).contains(charText)) {
                    objekList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class ViewHolder {
        private ImageView imageView;
        private TextView objekName;

        public ViewHolder(View v) {
            objekName = (TextView) v.findViewById(R.id.text);
        }
    }
}