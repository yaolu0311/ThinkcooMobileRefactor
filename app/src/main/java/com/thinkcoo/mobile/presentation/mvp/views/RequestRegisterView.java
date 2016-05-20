package com.thinkcoo.mobile.presentation.mvp.views;

/**
 * Created by Robert.yao on 2016/3/30.
 */
public interface RequestRegisterView extends VerifyCodeView{
    void gotoCompleteRegisterView(String phoneNumber);
}
