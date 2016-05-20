package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.NullFindPasswordToken;
import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Robert.yao on 2016/3/30.
 */
public class FindPasswordToken implements Nullable{

    public static final FindPasswordToken NULL_FINDPASSWORDTOKEN = new NullFindPasswordToken();

    private String userId;
    private String encryptStr;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptStr() {
        return encryptStr;
    }

    public void setEncryptStr(String encryptStr) {
        this.encryptStr = encryptStr;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
