package com.example.cheapeatsuoa.Model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.cheapeatsuoa.R;

public class Store extends BaseAdapter {
    //private int index;
    private Context mContext;
    //private String listImageFilename, storeName;

    public Integer[] mThumbIds = {
            R.drawable.city_1, R.drawable.city_2,
            R.drawable.city_3, R.drawable.city_4,
            R.drawable.city_5, R.drawable.city_6,
            R.drawable.city_7, R.drawable.city_8,
            R.drawable.city_9, R.drawable.city_10,
            R.drawable.city_11
    };

    // Constructor
    public Store(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
        return imageView;
    }



/*    public String getListImageFilename() {
        return listImageFilename;
    }

    public String getStoreName() {
        return storeName;
    }

    public Store(int index, String listImageFilename, String storeName) {
        this.index = index;
        this.listImageFilename = listImageFilename;
        this.storeName = storeName;
    }*/

}
