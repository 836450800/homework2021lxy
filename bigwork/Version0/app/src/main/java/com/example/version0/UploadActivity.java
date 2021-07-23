package com.example.version0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.version0.Constants.BASE_URL;
import static com.example.version0.Constants.STUDENT_ID;
import static com.example.version0.Constants.USER_NAME;
import static com.example.version0.Constants.token;

public class UploadActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_IMAGE = 101;
    private static final int REQUEST_CODE_VIDEO = 103;
    private static final String IMAGE_TYPE = "image/*";
    private static final String VIDEO_TYPE = "video/*";
    private static final long MAX_FILE_SIZE = 30 * 1024 * 1024;
    private IApi api;
    private Uri videoUri;
    private Uri coverImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_upload);
        initNetwork();
        findViewById(R.id.selectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFile(REQUEST_CODE_VIDEO,VIDEO_TYPE,"选择上传视频");
            }
        });

        findViewById(R.id.coverImageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFile(REQUEST_CODE_IMAGE,IMAGE_TYPE,"选择封面图片");
            }
        });

        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_VIDEO == requestCode){
            if(resultCode == Activity.RESULT_OK){
                videoUri = data.getData();
            }
        }

        if (REQUEST_CODE_IMAGE == requestCode){
            if(resultCode == Activity.RESULT_OK){
                coverImageUri = data.getData();
            }
        }
    }
    private void initNetwork() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(IApi.class);
    }

    private void getFile(int requestCode, String type, String title){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(type);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,false);
        intent.putExtra(Intent.EXTRA_TITLE, title);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, requestCode);
    }

    private void submit(){
        byte[] videoData = readDataFromUri(videoUri);

        if (videoData == null || videoData.length == 0){
            Toast.makeText(this, "视频不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        byte[] coverImageData = readDataFromUri(coverImageUri);
        if (coverImageData == null || coverImageData.length == 0){
            Toast.makeText(this, "封面图片不存在", Toast.LENGTH_SHORT).show();
            return;
        }
        if ( coverImageData.length + videoData.length >= MAX_FILE_SIZE) {
            Toast.makeText(this, "文件过大", Toast.LENGTH_SHORT).show();
            return;
        }
        MultipartBody.Part c_coverImage, c_video;
        c_coverImage = MultipartBody.Part.createFormData("cover_image", "cover.png", RequestBody.create(MediaType.parse("multipart/from-data"),coverImageData));
        c_video = MultipartBody.Part.createFormData("video", "content.mp4", RequestBody.create(MediaType.parse("multipart/from-data"), videoData));
        Call<UploadResponse> submit = api.submitMessage(STUDENT_ID, USER_NAME, "", c_coverImage, c_video, token);
        Log.d("Submit", submit.toString());
        submit.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {
                Log.d("Submit", "response" + response.toString());
                if (!response.isSuccessful()) {

                    Toast.makeText(getApplication(), "提交失败", Toast.LENGTH_SHORT).show();
                    Log.d("Submit", "提交失败");
                    return;
                } else {  Log.d("Submit","video"+videoUri.getPath());
                    Log.d("Submit","Imgae"+coverImageUri.getPath());
                    Toast.makeText(getApplication(), "提交成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UploadResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"错误发生！",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private byte[] readDataFromUri(Uri uri){
        byte[] data = null;
        try{
            InputStream is =getContentResolver().openInputStream(uri);
            data = Util.inputStream2bytes(is);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
