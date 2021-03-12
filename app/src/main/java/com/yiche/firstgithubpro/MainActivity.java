package com.yiche.firstgithubpro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.yiche.camerax.video.CameraActivity;
import com.yiche.camerax.video.CameraXRecordActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this, CameraActivity.class)
//                .putExtra("max", 3 + "");
//
//        startActivityForResult(intent, 0);
        Intent intent = new Intent(this, CameraXRecordActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 0) {
                String pathVideo2 = data.getStringExtra(CameraXRecordActivity.INTENT_EXTRA_VIDEO_PATH);
                Toast.makeText(this, pathVideo2, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
