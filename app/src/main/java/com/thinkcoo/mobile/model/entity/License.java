package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Administrator on 2016/5/19.
 */
public class License implements Nullable{

    String content;
    String url;

    public String getContent() {
        return content;
    }
    public String getUrl() {
        return url;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
