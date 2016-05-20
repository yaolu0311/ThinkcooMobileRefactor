package com.thinkcoo.mobile.presentation.mvp.views;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Robert.yao on 2016/3/29.
 */
public interface VerifyCodeView extends MvpView , BaseActivityHelpView ,BaseHintView {

    void setPhoneNumber(String phoneNumber);
    String getPhoneNumber();
    void setVerifyCode(String verificationCode);
    String getVerifyCode();
    void startGetVerifyCodeCountDown();
    void stopGetVerifyCodeCountDown();


}
