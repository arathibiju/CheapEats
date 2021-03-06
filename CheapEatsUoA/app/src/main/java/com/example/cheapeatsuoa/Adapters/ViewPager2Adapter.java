package com.example.cheapeatsuoa.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cheapeatsuoa.R;


public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>{

    // Array of image_view
    // Adding image_view from drawable folder
    private int[] images;
    private Context ctx;

    // Constructor of our ViewPager2Adapter class
    public ViewPager2Adapter(Context ctx, int[] images) {

        this.ctx = ctx;
        this.images = images;
    }

    // This method returns our layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.images_holder, parent, false);
        return new ViewHolder(view);
    }

    // This method binds the screen with the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // This will set the image_view in imageview
        holder.image_view.setImageResource(images[position]);

    }

    // This Method returns the size of the Array
    @Override
    public int getItemCount() {
        return images.length;
    }


    // The ViewHolder class holds the view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.images);
        }
    }

}
