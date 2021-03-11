package com.yiche.firstgithubpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.yiche.camerax.video.CameraActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, CameraActivity.class)
                .putExtra("max", 3 + "");

        startActivityForResult(intent, 0);
    }
}
