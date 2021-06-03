package com.example.cheapeatsuoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<Store> storeList;
    private ArrayList<Store> arraylist;

    public ListViewAdapter(Context context, ArrayList<Store> storeList, ArrayList<Store> grafton, ArrayList<Store> city) {
        mContext = context;
        this.storeList = storeList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(storeList);
        this.arraylist.addAll(grafton);
        this.arraylist.addAll(city);
    }

    class ViewHolder{
        ImageView icon;
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
            holder.icon = view.findViewById(R.id.search_list_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Set the results into TextViews
        holder.name.setText(storeList.get(position).getStoreName());
        int imageID = mContext.getResources().getIdentifier(storeList.get(position).getImage_b(), "drawable",
                mContext.getPackageName());
        holder.icon.setImageResource(imageID);

        return view;
    }

    public boolean filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        storeList.clear();
        if (charText.length() == 0) {
            storeList.clear();
        } else {
            for (Store wp : arraylist) {
                if (wp.getStoreName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    storeList.add(wp);
                }
            }
        }

        notifyDataSetChanged();
        return storeList.size() != 0;
    }

}