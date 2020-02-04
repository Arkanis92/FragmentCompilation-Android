package com.example.fragmentcompilation;

import android.os.Parcel;
import android.os.Parcelable;

public class BirthstoneObj implements Parcelable {
    private String stoneName;
    private int stoneImage;
    private String stoneDescription;

    public BirthstoneObj(String stoneName, int stoneImage, String stoneDescription) {
        this.stoneName = stoneName;
        this.stoneImage = stoneImage;
        this.stoneDescription = stoneDescription;
    }

    public String getStoneName() {
        return stoneName;
    }

    public void setStoneName(String stoneName) {
        this.stoneName = stoneName;
    }

    public String getStoneDescription() {
        return stoneDescription;
    }

    public void setStoneDescription(String stoneDescription) {
        this.stoneDescription = stoneDescription;
    }

    public int getStoneImage() {
        return stoneImage;
    }

    public void setStoneImage(int stoneImage) {
        this.stoneImage = stoneImage;
    }

    protected BirthstoneObj(Parcel in) {
        stoneName = in.readString();
        stoneDescription = in.readString();
        stoneImage = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stoneName);
        dest.writeString(stoneDescription);
        dest.writeInt(stoneImage);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<BirthstoneObj> CREATOR = new Parcelable.Creator<BirthstoneObj>() {
        @Override
        public BirthstoneObj createFromParcel(Parcel in) {
            return new BirthstoneObj(in);
        }

        @Override
        public BirthstoneObj[] newArray(int size) {
            return new BirthstoneObj[size];
        }
    };
}