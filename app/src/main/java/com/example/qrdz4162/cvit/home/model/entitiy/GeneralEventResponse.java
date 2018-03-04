package com.example.qrdz4162.cvit.home.model.entitiy;


/**
 * Created by qrdz4162 on 2/11/2018.
 */


import com.google.gson.annotations.SerializedName;

/**
 * GeneralEventResponse object which represent table that realm create into db
 */

public class GeneralEventResponse {

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("date")
    private String date;

}
