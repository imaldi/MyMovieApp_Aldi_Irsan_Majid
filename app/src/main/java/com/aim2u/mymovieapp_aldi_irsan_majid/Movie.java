package com.aim2u.mymovieapp_aldi_irsan_majid;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int poster;
    private String title;
    private String description;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(poster);
        parcel.writeString(title);
        parcel.writeString(description);
    }

    public Movie(){
    }

    protected Movie(Parcel in){
        //Entah apa yang merasukimu, urutan variabelnya tidak boleh tertukar....
        this.poster = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };
}
