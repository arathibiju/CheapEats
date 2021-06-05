package com.example.cheapeatsuoa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;



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

        //Text onClick//
        holder.textView.setOnClickListener(myViewHolder -> {
            Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);
            detailActivity.putExtra("FromActivity", mStores.get(position));
            mContext.startActivity(detailActivity);

            //Checks if most recent store clicked is already part of 'Recent Views'//
            //Currently compares store names which works for our data, in the future if there multiple stores with the same name this might be an issue
            if ((mStores.get(position).getStoreName()).equals(lastOnClickStore1.getStoreName())){
                lastOnClickStore3 = lastOnClickStore3;
                lastOnClickStore3.setDescription(lastOnClickStore3.getDescription());
                lastOnClickStore3.setCost(lastOnClickStore3.getCost());
                lastOnClickStore2 = lastOnClickStore2;
                lastOnClickStore2.setDescription(lastOnClickStore2.getDescription());
                lastOnClickStore2.setCost(lastOnClickStore2.getCost());
                lastOnClickStore1 = lastOnClickStore1;
                lastOnClickStore1.setDescription(lastOnClickStore1.getDescription());
                lastOnClickStore1.setCost(lastOnClickStore1.getCost());
            }
            else if ((mStores.get(position).getStoreName()).equals(lastOnClickStore2.getStoreName())){
                lastOnClickStore3 = lastOnClickStore3;
                lastOnClickStore3.setDescription(lastOnClickStore3.getDescription());
                lastOnClickStore3.setCost(lastOnClickStore3.getCost());
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore2.setDescription(lastOnClickStore1.getDescription());
                lastOnClickStore2.setCost(lastOnClickStore1.getCost());
                lastOnClickStore1 = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());
                lastOnClickStore1.setDescription(mStores.get(position).getDescription());
                lastOnClickStore1.setCost(mStores.get(position).getCost());
            }
            else {
                lastOnClickStore3 = lastOnClickStore2;
                lastOnClickStore3.setDescription(lastOnClickStore2.getDescription());
                lastOnClickStore3.setCost(lastOnClickStore2.getCost());
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore2.setDescription(lastOnClickStore1.getDescription());
                lastOnClickStore2.setCost(lastOnClickStore1.getCost());
                lastOnClickStore1 = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());
                lastOnClickStore1.setDescription(mStores.get(position).getDescription());
                lastOnClickStore1.setCost(mStores.get(position).getCost());
            }
        });

        //Image onClick//
        holder.imageView.setOnClickListener(myViewHolder -> {
            Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);

            detailActivity.putExtra("FromActivity", mStores.get(position)); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
            mContext.startActivity(detailActivity);

            //Checks if most recent store clicked is already part of 'Recent Views'//
            //Currently compares store names which works for our data, in the future if there multiple stores with the same name this might be an issue
            if ((mStores.get(position).getStoreName()).equals(lastOnClickStore1.getStoreName())){
                lastOnClickStore3 = lastOnClickStore3;
                lastOnClickStore3.setDescription(lastOnClickStore3.getDescription());
                lastOnClickStore3.setCost(lastOnClickStore3.getCost());
                lastOnClickStore2 = lastOnClickStore2;
                lastOnClickStore2.setDescription(lastOnClickStore2.getDescription());
                lastOnClickStore2.setCost(lastOnClickStore2.getCost());
                lastOnClickStore1 = lastOnClickStore1;
                lastOnClickStore1.setDescription(lastOnClickStore1.getDescription());
                lastOnClickStore1.setCost(lastOnClickStore1.getCost());
            }
            else if ((mStores.get(position).getStoreName()).equals(lastOnClickStore2.getStoreName())){
                lastOnClickStore3 = lastOnClickStore3;
                lastOnClickStore3.setDescription(lastOnClickStore3.getDescription());
                lastOnClickStore3.setCost(lastOnClickStore3.getCost());
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore2.setDescription(lastOnClickStore1.getDescription());
                lastOnClickStore2.setCost(lastOnClickStore1.getCost());
                lastOnClickStore1 = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());
                lastOnClickStore1.setDescription(mStores.get(position).getDescription());
                lastOnClickStore1.setCost(mStores.get(position).getCost());
            }
            else {
                lastOnClickStore3 = lastOnClickStore2;
                lastOnClickStore3.setDescription(lastOnClickStore2.getDescription());
                lastOnClickStore3.setCost(lastOnClickStore2.getCost());
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore2.setDescription(lastOnClickStore1.getDescription());
                lastOnClickStore2.setCost(lastOnClickStore1.getCost());
                lastOnClickStore1 = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),mStores.get(position).getStoreName(),mStores.get(position).getLocation());
                lastOnClickStore1.setDescription(mStores.get(position).getDescription());
                lastOnClickStore1.setCost(mStores.get(position).getCost());
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

