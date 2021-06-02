package com.example.cheapeatsuoa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheapeatsuoa.Data.DataProvider;
import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    ArrayList<Store> mStores;
    int mLayoutID;
    Context mContext;


    public RecyclerViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Store> objects) {
       super();
        mLayoutID = resource;
        mContext = context;
        mStores = objects;
        //this.objects = objects;
        //this.arr2 = arr2;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        myViewHolder myViewHolder = new myViewHolder(view);

        myViewHolder.textView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myViewHolder){
                Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);
                detailActivity.putExtra("FromActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                mContext.startActivity(detailActivity);
            }
        });

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View myViewHolder){
                Intent detailActivity = new Intent(mContext,StoreDetailActivity.class);
                detailActivity.putExtra("FromActivity", "I'm from the MainActivity"); // sending object is more proffessional way byt then we need to add more code t change class to serializable or parseable
                mContext.startActivity(detailActivity);
            }
        });

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Store currentNumber = mStores.get(position);
        int i = mContext.getResources().getIdentifier(currentNumber.getImage(), "drawable",
                mContext.getPackageName());

        holder.imageView.setImageResource(i);
        holder.textView.setText(mStores.get(position).getStoreName());
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

