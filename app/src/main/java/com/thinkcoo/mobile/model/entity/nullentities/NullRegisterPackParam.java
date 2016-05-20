package com.thinkcoo.mobile.model.entity.nullentities;

import com.thinkcoo.mobile.model.entity.RegisterPackParam;

/**
 * Created by Robert.yao on 2016/3/29.
 */
public class NullRegisterPackParam extends RegisterPackParam {

    @Override
    public boolean isEmpty() {
        return true;
    }
}
