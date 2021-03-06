package com.example.version0;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message {

    @SerializedName("_id")
    private String _id;
    @SerializedName("student_id")
    private String studentId;
    @SerializedName("user_name")
    private String user_name;
    @SerializedName("extra_value")
    private String extra_value;
    @SerializedName("video_url")
    private String video_url;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("image_w")
    private int imageW;
    @SerializedName("image_h")
    private int imageH;
    @SerializedName("createdAt")
    private Date createdAt;
    @SerializedName("updatedAt")
    private Date updatedAt;

    public void setId(String Id) {
        this._id = Id;
    }
    public String getId() {
        return _id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setExtra_value(String extra_value) {this.extra_value = extra_value;}
    public String getExtra_value() {return extra_value;}

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
    public String getVideo_url() {
        return video_url;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageW(int imageW) {
        this.imageW = imageW;
    }
    public int getImageW() {
        return imageW;
    }

    public void setImageH(int imageH) {
        this.imageH = imageH;
    }
    public int getImageH() {
        return imageH;
    }

    public void setCreatedAt(Date createdat) {
        this.createdAt = createdat;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAtt(Date updatedat) {
        this.updatedAt = updatedat;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }

}