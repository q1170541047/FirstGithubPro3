package com.yiche.camerax.video;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiche.camerax.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/23.
 */

public class PhotoXAdapter extends BaseQuickAdapter<ImageItem, BaseViewHolder> {
    public PhotoXAdapter(ArrayList<ImageItem> data) {
        super(R.layout.item_test, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ImageItem imageItem) {
        ImageView view = (ImageView) baseViewHolder.getView(R.id.iv);
        ImageView ivSelect = (ImageView) baseViewHolder.getView(R.id.ivSelect);
        baseViewHolder.addOnClickListener(R.id.ivSelect);
        GlideUtils.getGlideUtils().loadGlide(mContext, imageItem.path, R.mipmap.moren, view);
        if (imageItem.isSelect == 1) {
            ivSelect.setImageResource(R.mipmap.select_delet);
        } else {
            ivSelect.setImageResource(R.mipmap.photo_delet);
        }
    }
}
