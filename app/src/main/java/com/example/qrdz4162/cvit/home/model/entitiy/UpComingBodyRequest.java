package com.example.qrdz4162.cvit.home.model.entitiy;

/**
 * Created by qrdz4162 on 2/28/2018.
 */

public class UpComingBodyRequest {

    public UpComingBodyRequest (int userId){
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;
}
