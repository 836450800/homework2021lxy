package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Btn1=findViewById(R.id.btn1),Btn2=findViewById(R.id.btn2),Btn3=findViewById(R.id.btn3);
        Button Btn4=findViewById(R.id.btn4),Btn5=findViewById(R.id.btn5);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,getString(R.string.New),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Activity_Two.class);
                startActivity(intent);
            }

        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"进入百度",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"进入拨号",Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(Intent.ACTION_CALL_BUTTON);
                startActivity(intent);
            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Enter UI",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Activity_UI.class);
                startActivity(intent);
            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"打开热搜",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,ReSou.class);
                startActivity(intent);
            }
        });
        Log.i("MainActivity","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }
}
