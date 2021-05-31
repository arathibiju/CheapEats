package com.example.cheapeatsuoa;

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

    //ArrayList<Store> arr;
    int [] arr2;

    public RecyclerViewAdapter(int [] arr2) {
        //this.arr = arr;
        this.arr2 = arr2;
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
    holder.imageView.setImageResource(arr2[position]);
    holder.textView.setText("store no." + (position+1));
    }

    @Override
    public int getItemCount() {
        return arr2.length;
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

