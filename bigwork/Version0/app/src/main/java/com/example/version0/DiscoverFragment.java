package com.example.version0;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static android.os.Looper.getMainLooper;
import static com.example.version0.Constants.BASE_URL;


public class DiscoverFragment extends AppCompatActivity implements FeedAdapter.IOnItemClickListener{
    private FeedAdapter adapter = new FeedAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_discover);

        RecyclerView recyclerView = findViewById(R.id.rv_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener( this);
        recyclerView.setAdapter(adapter);
        getData(null); Log.i("Create","OK");
    };
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Create", "RecyclerViewActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Create", "RecyclerViewActivity onResume");
    }
    private void getData(final String studentId){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<VideoData> messages = baseGetReposFromRemote(
                        studentId, Constants.token);

                if (messages!= null && !messages.isEmpty()) {
                    new Handler(getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.setData(messages);
                        }
                    });

                }
            }
        }).start();
    }

    public List<VideoData> baseGetReposFromRemote(String studentId, String accept) {

        String urlStr =
                String.format((Constants.BASE_URL+"/video?%s"),studentId);
        List<VideoData> result = null;
        VideoResponse temp = null;


        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(600);

            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {

                InputStream in = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                temp = new Gson().fromJson(reader, new TypeToken<VideoResponse>() {
                }.getType());
                result = temp.feeds;
                reader.close();
                in.close();

            } else {

            }
            conn.disconnect();
            Log.i("Create","???");

        } catch (final Exception e) {
            e.printStackTrace();
           runOnUiThread(new Runnable() {
                @Override
                public void run() {


                }
            });
        }
        return result;
    }
    public void onItemCLick(int position, VideoData data) {

        Intent intent = new Intent(DiscoverFragment.this, VideoDetail.class);
        intent.putExtra("1",data.getVideoUrl()); Log.d(">ideo","..." );
        startActivity(intent);
        Log.d(">ideo","ffff" );
    }
}
