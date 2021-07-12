package com.example.homework_chapter_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button1),btn2=findViewById(R.id.button_2);
        RadioButton rbtn=findViewById(R.id.rBtn);
        final TextView tv = findViewById(R.id.tv_title);
        rbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tv.setText("RadioButton!");
                Log.d("44444", "onClickListener: 44444");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Bad！");
                Log.d("333333", "onClickListener: 333333");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Good！");
                Log.d("222222", "onClickListener: 222222");
            }

        });


         Log.d("111111", "onCreate: 1111");
    }
}
