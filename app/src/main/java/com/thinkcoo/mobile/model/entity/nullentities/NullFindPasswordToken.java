package com.thinkcoo.mobile.model.entity.nullentities;

import com.thinkcoo.mobile.model.entity.FindPasswordToken;

/**
 * Created by Robert.yao on 2016/3/30.
 */
public class NullFindPasswordToken extends FindPasswordToken {

    @Override
    public boolean isEmpty() {
        return true;
    }
}
