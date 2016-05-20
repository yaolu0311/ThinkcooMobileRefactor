package com.thinkcoo.mobile.presentation.views.activitys.base;

import android.content.Context;
import android.content.Intent;
import com.thinkcoo.mobile.presentation.views.activitys.LoginActivity;
import javax.inject.Inject;


/**
 * Created by Robert.yao on 2016/3/21.
 * 全局导航类，负责整个应用程序的页面跳转
 */
public class Navigator {


    @Inject
    public Navigator(){}

    /**
     * 跳转到新用户使用提醒界面
     * @param context activity context
     */
    public void navigateToNewGuidance(Context context){
        //context.startActivity(NewUserGuidanceActivity.getNewUserGuidanceIntent(context));
    }

    /**
     * 跳转到登录界面
     * @param context activity context
     */
    public void navigateToLogin(Context context){
        //context.startActivity(LoginActivity.getLoginIntent(context));
    }


    /**
     * 跳转到注册
     *
     */
    public void navigateToRegister(Context context) {
        //TODO
    }

    /**
     * 跳转到找回密码
     *
     */
    public void navigateToGotPassword(Context context) {
        //// TODO: 2016/3/22
    }

    /**
     * 跳转到主界面
     * @param context
     */
    public void navigateToHome(Context context){}

    /***
     * 跳转到完成注册界面(设置密码)
     * @param context
     * @param phoneNumber
     */
    public void navigateToCompleteRegister(Context context , String phoneNumber) {
        //Intent intent = CompleteRegisterActivity.getIntent(context,phoneNumber);
        //context.startActivity(intent);
    }
}
