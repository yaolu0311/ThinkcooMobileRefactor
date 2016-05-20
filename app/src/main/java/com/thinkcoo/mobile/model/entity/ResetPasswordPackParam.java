package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Robert.yao on 2016/3/30.
 */
public class ResetPasswordPackParam implements Nullable{

    private String cert;
    private String userId;
    private String password;

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    @Override
    public String toString() {
        return "ResetPasswordPackParam{" +
                "cert='" + cert + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
