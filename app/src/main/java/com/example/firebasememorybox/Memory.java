package com.example.firebasememorybox;

import android.os.Parcel;
import android.os.Parcelable;

public class Memory implements Parcelable {
    private int rating;
    private String name;
    private String desc;
    String docID;


    public Memory(int rating, String name, String desc, String docID) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.docID = docID;
    }

    public Memory(int rating, String name, String desc) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.docID = "No docID yet";
    }


    @Override
    public String toString() {
        return name;
    }

    public int getRating() {return rating;}
    public void setRating(int rating) {this.rating = rating;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }


    public static final Parcelable.Creator<Memory> CREATOR = new
            Parcelable.Creator<Memory>() {

                @Override
                public Memory createFromParcel(Parcel parcel) {
                    return new Memory(parcel);
                }

                @Override
                public Memory[] newArray(int size) {
                    return new Memory[0];
                }
            };



    public Memory(Parcel parcel) {
        name = parcel.readString();
        rating = parcel.readInt();
        desc = parcel.readString();
        docID = parcel.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(rating);
        dest.writeString(desc);
        dest.writeString(docID);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public Memory() {
        name = "";
        rating = 0;
        desc = "";
        docID = "";
    }
}