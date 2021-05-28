package com.example.cheapeatsuoa.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Store implements Parcelable {

    private int index;
    private String image, image_b, image_c;
    private String location, storeName, description, review;

    public Store (int index,String image, String image_b, String image_c, String storeName ){
        this.index = index;
        this.image = image;
        this.image_b = image_b;
        this.image_c = image_c;
        this.storeName = storeName;
    }
    private Store(Parcel in) {
        index = in.readInt();
        //location = in.readString();
        //description = in.readString();
        //review = in.readString();
        storeName = in.readString();
        image = in.readString();
        image_b = in.readString();
        image_c = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    // write object's data to the passed-in Parcel
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(index);
        //dest.writeString(location);
        //dest.writeString(description);
       // dest.writeString(review);
        dest.writeString(storeName);
        dest.writeString(image);
        dest.writeString(image_b);
        dest.writeString(image_c);
    }

    public int getIndex() {
        return index;
    }

    public String getImage() {
        return image;
    }

    public String getImage_b() {
        return image_b;
    }

    public String getImage_c() {
        return image_c;
    }

    public String getLocation() {
        return location;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDescription() {
        return description;
    }

    public String getReview() {
        return review;
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
