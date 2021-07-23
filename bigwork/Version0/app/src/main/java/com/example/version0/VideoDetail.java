package com.example.version0;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoDetail extends AppCompatActivity {

    MediaPlayer player = new MediaPlayer();
    String mockUrl;
    android.widget.RelativeLayout.LayoutParams originalParams;
    VideoView videoView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(">ideo","?ddd");
        super.onCreate(savedInstanceState);  Log.d(">ideo","?");
        setContentView(R.layout.activity_video_detail);

        videoView = findViewById(R.id.videoView);
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        originalParams = (android.widget.RelativeLayout.LayoutParams) videoView.getLayoutParams();
        Log.i(">ideo",">>");
        mockUrl=getIntent().getStringExtra("1");
        videoView.setVideoURI(Uri.parse(mockUrl));



        videoView.setMediaController(new MediaController(this));
        videoView.start();

    }
}
