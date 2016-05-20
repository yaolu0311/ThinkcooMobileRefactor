package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.NullCheckVerifyCodePackParam;
import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Robert.yao on 2016/3/29.
 */
public class CheckVerifyCodePackParam implements Nullable{

    public static CheckVerifyCodePackParam nullVerifycheckinfo = new NullCheckVerifyCodePackParam();

    private String phoneNumber;
    private String verifyCode;
    private String cert;
    private int isValidate;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(int isValidate) {
        this.isValidate = isValidate;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
