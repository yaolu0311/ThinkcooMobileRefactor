package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.NullVerifyCodeInfo;
import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Robert.yao on 2016/3/29.
 */
public class VerifyCode implements Nullable{

    public static final VerifyCode NULL_VERIFYCODEINFO = new NullVerifyCodeInfo();

    private String codeStr;
    private String encryptStr;

    public String getVerifyCode() {
        return codeStr;
    }

    public void setVerifyCode(String verifyCode) {
        this.codeStr = verifyCode;
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
