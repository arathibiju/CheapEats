package com.example.cheapeatsuoa.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheapeatsuoa.Activities.StoreDetailActivity;
import com.example.cheapeatsuoa.Model.Store;
import com.example.cheapeatsuoa.R;

import java.util.ArrayList;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    //Initialise recent stores//
    public static Store lastOnClickStore1 = new Store ( 0, "city_1", "city_1b",
            "city_1c", "Mojo", "HSB Courtyard, Auckland University, 10 Symonds Street",
            "$10 per person", "Cafe");
    public static Store lastOnClickStore2 = new Store ( 1,"grafton_2", "grafton_2b",
            "grafton_2c","Poké House", "110 Grafton Rd Grafton",
            "$20 per person", "Salad, Poké" );

    public static Store lastOnClickStore3 = new Store ( 2, "off_3", "off_3b",
            "off_3c", "Sumthin Dumplin", "18-26 Wellesley Street E, Auckland",
            "$15 per person", "Dumplings, Chinese, Fusion");

    ArrayList<Store> mStores;
    int mLayoutID;
    Context mContext;
    String activity;

    
    public RecyclerViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Store> objects, String activity) {
       super();
        mLayoutID = resource;
        mContext = context;
        mStores = objects;
        this.activity = activity;

    }

//Uses recycler view when activity is created to display all stores
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        myViewHolder myViewHolder = new myViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //Goes through and displays the entire array list of stores for each activity
        Store currentStore = mStores.get(position);
        int i = mContext.getResources().getIdentifier(currentStore.getImage(), "drawable",
                mContext.getPackageName());

        holder.imageView.setImageResource(i);
        holder.textView.setText(mStores.get(position).getStoreName());

        //Text onClick//
        holder.textView.setOnClickListener(myViewHolder -> {
            //Sends store information to detail activity
            Intent detailActivity = new Intent(mContext, StoreDetailActivity.class);
            detailActivity.putExtra("FromActivity", mStores.get(position));
            detailActivity.putExtra("recycleView", activity);
            mContext.startActivity(detailActivity);

            //Checks if most recent store clicked is already part of 'Recent Views'//
            //Currently compares store names which works for our data, in the future if there multiple stores with the same name this might be an issue
            if ((mStores.get(position).getStoreName()).equals(lastOnClickStore1.getStoreName())){

            }
            else if ((mStores.get(position).getStoreName()).equals(lastOnClickStore2.getStoreName())){
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore1 = makeNewStore(position);
            }
            else {
                lastOnClickStore3 = lastOnClickStore2;
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore1 = makeNewStore(position);
            }
        });

        //Image onClick//
        holder.imageView.setOnClickListener(myViewHolder -> {
            //Sends store information to detail activity
            Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);
            detailActivity.putExtra("FromActivity", mStores.get(position));
            detailActivity.putExtra("recycleView", activity);
            mContext.startActivity(detailActivity);

            //Checks if most recent store clicked is already part of 'Recent Views'//
            //Currently compares store names which works for our data, in the future if there multiple stores with the same name this might be an issue
            if ((mStores.get(position).getStoreName()).equals(lastOnClickStore1.getStoreName())){

            }
            else if ((mStores.get(position).getStoreName()).equals(lastOnClickStore2.getStoreName())){
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore1 = makeNewStore(position);
            }
            else {
                lastOnClickStore3 = lastOnClickStore2;
                lastOnClickStore2 = lastOnClickStore1;
                lastOnClickStore1 = makeNewStore(position);
            }
        });
    }
//This function checks how many stores are in each activity
    @Override
    public int getItemCount() {
        return mStores.size();
    }

//View holder displays image and text for each store//
    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView =itemView.findViewById(R.id.textView);
        }
    }

    //Makes new store by unpacking the current store of type 'parcel' for recently visited stores//
    public Store makeNewStore(int position){
        Store newStore = new Store (mStores.get(position).getIndex(), mStores.get(position).getImage(),
                mStores.get(position).getImage_b(),mStores.get(position).getImage_c(),
                mStores.get(position).getStoreName(),mStores.get(position).getLocation(),
                mStores.get(position).getCost(), mStores.get(position).getDescription());
        return newStore;
    }
}



