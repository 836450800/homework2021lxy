package com.example.version0;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoResponse {
    @SerializedName("feeds")
    public List<VideoData> feeds;
    @SerializedName("success")
    public boolean success;
}
