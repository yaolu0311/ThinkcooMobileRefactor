package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.NullRegisterPackParam;
import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Robert.yao on 2016/3/29.
 */
public class RegisterPackParam implements Nullable{

    public static final RegisterPackParam NULL_REGISTERINFO = new NullRegisterPackParam();

    private String phoneNumber;
    private String passWord;
    private String areaCode;

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


}
