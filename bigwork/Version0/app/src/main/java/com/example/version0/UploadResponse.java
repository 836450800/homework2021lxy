package com.example.version0;

import android.os.Message;

import com.google.gson.annotations.SerializedName;

public class UploadResponse {
    @SerializedName("result")
    public Message message;
    @SerializedName("success")
    public boolean success;

    @SerializedName("error")
    public String error;
}
