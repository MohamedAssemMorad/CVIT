package com.example.qrdz4162.cvit.home.model.entitiy;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qrdz4162 on 2/7/2018.
 */

public class BannerResponse {

    public String getBanId() {
        return banId;
    }

    public void setBanId(String banId) {
        this.banId = banId;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(String videoStatus) {
        this.videoStatus = videoStatus;
    }

    public String getTargetLink() {
        return targetLink;
    }

    public void setTargetLink(String targetLink) {
        this.targetLink = targetLink;
    }

    public String getTargetStatus() {
        return targetStatus;
    }

    public void setTargetStatus(String targetStatus) {
        this.targetStatus = targetStatus;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }

    @SerializedName("banId")
    private String banId;
    @SerializedName("imgLink")
    private String imgLink;
    @SerializedName("videoLink")
    private String videoLink;
    @SerializedName("videoStatus")
    private String videoStatus;
    @SerializedName("targetLink")
    private String targetLink;
    @SerializedName("targetStatus")
    private String targetStatus;
    @SerializedName("targetUser")
    private String targetUser;


}
