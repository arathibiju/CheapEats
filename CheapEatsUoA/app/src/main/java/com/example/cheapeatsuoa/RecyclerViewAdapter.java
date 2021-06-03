package com.example.cheapeatsuoa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    ArrayList<Store> mStores;
    public static Store lastOnClickStore1 = new Store ( 0, "city_1", "city_1b", "city_1c", "Mojo", "HSB Courtyard, Auckland University, 10 Symonds Street");
    public static Store lastOnClickStore2 = new Store ( 1,"grafton_2", "grafton_2b", "grafton_2c","Poke House", "110 Grafton Rd Grafton" );
    public static Store lastOnClickStore3 = new Store ( 2, "off_3", "off_3b", "off_3c", "Sumthin Dumplin", "18-26 Wellesley Street E, Auckland, Auckland 1010, New Zealand");
    int mLayoutID;
    Context mContext;


    public RecyclerViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Store> objects) {
       super();
        mLayoutID = resource;
        mContext = context;
        mStores = objects;

    }

    /*public static ArrayList<Store> getRecentStores(Context c) {
            ArrayList<Store> storeList = new ArrayList<Store>();
            storeList.add(c.get(position));
            return storeList;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        myViewHolder myViewHolder = new myViewHolder(view);



        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Store currentNumber = mStores.get(position);
        int i = mContext.getResources().getIdentifier(currentNumber.getImage(), "drawable",
                mContext.getPackageName());

        holder.imageView.setImageResource(i);
        holder.textView.setText(mStores.get(position).getStoreName());
        //lastOnClickStore = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());


        holder.textView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myViewHolder){
                Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);
                detailActivity.putExtra("FromActivity", mStores.get(position)); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                mContext.startActivity(detailActivity);
                lastOnClickStore3 = lastOnClickStore2;
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore1 = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());

            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View myViewHolder){
                Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);
                detailActivity.putExtra("FromActivity", mStores.get(position)); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                mContext.startActivity(detailActivity);
                //(0, "city_1", "city_1b", "city_1c", "Mojo", "HSB Courtyard, Auckland University, 10 Symonds Street");
                //lastOnClickStore = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());
                //DataProvider.getRecentStores(mStores.get(position));
/*                ArrayList<Store> storeList = new ArrayList<Store>(3);
                storeList.add(mStores.get(position));*/
                lastOnClickStore3 = lastOnClickStore2;
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore1 = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());
            }

        });
    }

    @Override
    public int getItemCount() {
        return mStores.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView =itemView.findViewById(R.id.textView);
        }

    }
}

