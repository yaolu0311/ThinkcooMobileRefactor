package com.thinkcoo.mobile.model.entity;

import com.thinkcoo.mobile.model.entity.nullentities.Nullable;

/**
 * Created by Administrator on 2016/5/19.
 */
public class Vcode implements Nullable{

    /**
     * 验证码内容，4位数字短号组成
     */
    private String content;
    /**
     * 验证码Token
     */
    private String cert;
    /**
     * 验证码对应的账号
     */
    private Account account;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}
