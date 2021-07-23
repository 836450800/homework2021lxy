package com.example.version0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button uploadBtn = findViewById(R.id.BtnUpload);
        Button recordBtn = findViewById(R.id.BtnRecord);
        Button viewBtn=findViewById(R.id.BtnView);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Intent =new Intent(MainActivity.this, DiscoverFragment.class);
                startActivity(Intent);
            }
        });
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toUploadIntent =new Intent(MainActivity.this, UploadActivity.class);
                startActivity(toUploadIntent);
            }
        });

        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecordIntent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(toRecordIntent);
            }
        });
    }
}