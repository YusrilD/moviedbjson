package com.example.theater;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Movies implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("voteAverage")
    private int voteAverage;
    @SerializedName("voteCount")
    private int voteCount;
    @SerializedName("originalTitle")
    private String originalTitle;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("backdropPath")
    private String backdropPath;
    @SerializedName("overview")
    private String overview;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("posterPath")
    private String posterPath;

    public Movies() {

    }

    public Movies(
            int id,
            int voteAverage,
            int voteCount,
            String originalTitle,
            String title,
            double popularity,
            String backdropPath,
            String overview,
            String releaseDate,
            String posterPath) {

        this.id = id;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.originalTitle = originalTitle;
        this.title = title;
        this.popularity = popularity;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
    }

    protected Movies(Parcel in) {
        id = in.readInt();
        voteAverage = in.readInt();
        voteCount = in.readInt();
        originalTitle = in.readString();
        title = in.readString();
        popularity = in.readDouble();
        backdropPath = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        posterPath = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(voteAverage);
        dest.writeInt(voteCount);
        dest.writeString(originalTitle);
        dest.writeString(title);
        dest.writeDouble(popularity);
        dest.writeString(backdropPath);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeString(posterPath);
    }
}