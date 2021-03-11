package com.yiche.camerax.video;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧 Github地址：https://github.com/jeasonlzy0216
 * 版    本：1.0
 * 创建日期：2016/5/19
 * 描    述：图片信息
 * 修订历史：
 * ================================================
 */
public class ImageItem implements Serializable, Parcelable {

    public String name="";       //图片的名字
    public String path;       //图片的路径
    public long size;         //图片的大小
    public int width;         //图片的宽度
    public int height;        //图片的高度
    public String mimeType;   //图片的类型
    public long addTime;      //图片的创建时间
    public String id;       //接口要的fileID
    public int c; //判断是否是上个界面给的图片，1是0默认
    public String url="";
    public String tag;
    public String tagID;
    public int isShow;
    public String cursorpath;
    public  long currentSize;  //当前进度
    public long totalSize;  //总进度


    public int isSelect;//用于标记是否选择


    public int finish;   //0是没完成1是完成了啊里上传2是完成公司服务器上传3是阿里上传失败4是服务器上传失败

    /** 图片的路径和创建时间相同就认为是同一张图片 */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ImageItem) {
            ImageItem item = (ImageItem) o;
            return this.path.equalsIgnoreCase(item.path) && this.addTime == item.addTime;
        }

        return super.equals(o);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.path);
        dest.writeString(this.cursorpath);
        dest.writeLong(this.size);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.mimeType);
        dest.writeLong(this.addTime);
        dest.writeLong(this.currentSize);
        dest.writeLong(this.totalSize);
        dest.writeInt(this.finish);
        dest.writeString(this.id);
        dest.writeInt(this.c);
        dest.writeInt(this.isSelect);
        dest.writeString(this.tag);
        dest.writeString(this.tagID);
        dest.writeInt(this.isShow);
    }

    public ImageItem() {
    }

    protected ImageItem(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
        this.path = in.readString();
        this.cursorpath = in.readString();
        this.size = in.readLong();
        this.width = in.readInt();
        this.height = in.readInt();
        this.mimeType = in.readString();
        this.addTime = in.readLong();
        this.currentSize=in.readLong();
        this.totalSize=in.readLong();
        this.finish=in.readInt();
        this.id=in.readString();
        this.c=in.readInt();
        this.isSelect=in.readInt();
        this.tag=in.readString();
        this.tagID=in.readString();
        this.isShow=in.readInt();
    }

    public static final Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel source) {
            return new ImageItem(source);
        }
        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };
}
