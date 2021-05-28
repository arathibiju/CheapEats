package com.example.cheapeatsuoa.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Store implements Parcelable {
    private int index, image, image_b, image_c;
    private String location, storeName, description, review;


    protected Store(Parcel in) {
        index = in.readInt();
        //location = in.readString();
        //description = in.readString();
        //review = in.readString();
        storeName = in.readString();
        image = in.readInt();
        image_b = in.readInt();
        image_c = in.readInt();
    }
    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };


    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    // write object's data to the passed-in Parcel
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(image_c);
        dest.writeInt(image_b);
        dest.writeInt(image);
        dest.writeString(storeName);
       // dest.writeString(review);
        //dest.writeString(description);
        //dest.writeString(location);
        dest.writeInt(index);
    }



/*    public String getListImageFilename() {
        return location;
    }

    public String getStoreName() {
        return storeName;
    }

    public Store(int index, String location, String storeName) {
        this.index = index;
        this.location = location;
        this.storeName = storeName;
    }*/

}
