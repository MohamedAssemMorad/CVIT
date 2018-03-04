package com.example.qrdz4162.cvit.home.model.entitiy;


import com.google.gson.annotations.SerializedName;

/**
 * Created by qrdz4162 on 2/7/2018.
 */


/**
 * UpComingEventsResponse represent movieItem response and implements Parcelable
 * to parse object to be able to set in bundle
 */
public class UpComingEventsResponse{

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getNASY_Id() {
        return NASY_Id;
    }

    public void setNASY_Id(String NASY_Id) {
        this.NASY_Id = NASY_Id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPic() {
        return contactPic;
    }

    public void setContactPic(String contactPic) {
        this.contactPic = contactPic;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    @SerializedName("contactMobile")
    private String contactMobile;
    @SerializedName("NASY_Id")
    private String NASY_Id;
    @SerializedName("contactName")
    private String contactName;
    @SerializedName("contactPic")
    private String contactPic;
    @SerializedName("eventName")
    private String eventName;
    @SerializedName("eventDate")
    private String eventDate;


}
