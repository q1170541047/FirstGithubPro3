package com.yiche.camerax.video;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.request.RequestOptions;
import com.yiche.camerax.R;

import java.io.File;


/**
 * @author 1yqg
 *         crated at 2016/9/6
 * @name glide 图片加载
 * @description
 */
public class GlideUtils {

    private static GlideUtils instance;

    private GlideUtils() {
    }

    public static GlideUtils getGlideUtils() {
        if (instance == null) {
            instance = new GlideUtils();
        }
        return instance;
    }


    /**
     * 图片加载 glide
     *
     * @param context
     * @param imgUrl
     * @param defaultImgId
     * @param iv
     */
    public static void loadGlide(Context context, String imgUrl, int defaultImgId, final ImageView iv) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(defaultImgId);
        requestOptions.error(defaultImgId);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(imgUrl).apply(requestOptions).into(iv);

//        DrawableRequestBuilder requestBuilder = Glide.with(context)
//                .load(imgUrl)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE);//是将图片原尺寸缓存到本地
//        requestBuilder.error(defaultImgId);
////        if (defaultImgId != 0) {
////            requestBuilder.placeholder(defaultImgId);
////        }
//        requestBuilder.dontAnimate();
//        requestBuilder.into(iv);

        //.skipMemoryCache(true)//不缓存到内存中
        //.diskCacheStrategy(DiskCacheStrategy.NONE)//不硬盘缓存
        //.crossFade(R.anim.fade_out_rapidly, 5000)
        //pauseRequests()取消请求
        //resumeRequests()恢复请求
        //Glide.clear() 清除掉所有的图片加载请求
    }

}
