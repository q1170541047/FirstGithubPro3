package com.yiche.camerax.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.yiche.camerax.R;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * author：chs
 * date：2020/5/25
 * des： 预览
 */
public class PreviewActivity extends AppCompatActivity {
    public static final String KEY_PREVIEW_URL = "key_preview_url";
    public static final String KEY_IS_VIDEO = "key_is_video";
    private PhotoView mPhotoView;
    private VideoView mVideoView;


    public static void start(Activity activity, String previewUrl, boolean isVideo) {
        Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(KEY_PREVIEW_URL, previewUrl);
        intent.putExtra(KEY_IS_VIDEO, isVideo);
        activity.startActivityForResult(intent,0);
    }

    boolean isVideo;
    String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initTitlebar();
        mPhotoView = findViewById(R.id.photo_view);
        mVideoView = findViewById(R.id.video_view);
        path = getIntent().getStringExtra(KEY_PREVIEW_URL);
        Log.d("MAIN123", path);
        isVideo = getIntent().getBooleanExtra(KEY_IS_VIDEO, false);
        if (!isVideo) {
            Glide.with(this).load(path).into(mPhotoView);
            mVideoView.setVisibility(View.GONE);
        } else {
            mPhotoView.setVisibility(View.GONE);
            showVideo(path);
        }

    }

    private void initTitlebar() {
        TextView title_rightTv=findViewById(R.id.title_rightTv);
        TextView title_finishTv=findViewById(R.id.title_finishTv);
        title_rightTv.setOnClickListener(v -> {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();

        });
        title_finishTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void showVideo(String path) {
        MediaController controller = new MediaController(this);
        mVideoView.setVideoPath(path);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);
        mVideoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }
}
