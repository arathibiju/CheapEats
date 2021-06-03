package com.example.cheapeatsuoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<Store> storeList = null;
    private ArrayList<Store> arraylist;

    public ListViewAdapter(Context context, ArrayList<Store> storeList) {
        mContext = context;
        this.storeList = storeList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Store>();
        this.arraylist.addAll(storeList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return storeList.size();
    }

    @Override
    public Store getItem(int position) {
        return storeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, parent,false);
            // Locate the TextViews in listview_item.xml
            holder.name =  view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Set the results into TextViews
        holder.name.setText(storeList.get(position).getStoreName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        storeList.clear();
        if (charText.length() == 0) {
            storeList.addAll(arraylist);
        } else {
            for (Store wp : arraylist) {
                if (wp.getStoreName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    storeList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}