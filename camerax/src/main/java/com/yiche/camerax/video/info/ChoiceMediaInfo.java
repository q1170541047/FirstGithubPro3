package com.yiche.camerax.video.info;

import java.io.Serializable;

/**
 * @Description: java类作用描述
 * @Author: yiche_li
 * @CreateDate: 2021/2/23 13:19
 * @UpdateUser: 更新者：
 * @UpdateDate: 2021/2/23 13:19
 */

public class ChoiceMediaInfo implements Serializable {
    String path;
    String imagePath;
    int type;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ChoiceMediaInfo(String path, String imagePath, int type) {
        this.path = path;
        this.imagePath = imagePath;
        this.type = type;
    }
}
