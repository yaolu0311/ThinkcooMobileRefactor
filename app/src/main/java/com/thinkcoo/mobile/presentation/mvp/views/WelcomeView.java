package com.thinkcoo.mobile.presentation.mvp.views;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.thinkcoo.mobile.model.entity.User;

/**
 * Created by Administrator on 2016/3/16.
 */
public interface WelcomeView extends MvpView , BaseActivityHelpView{
    void gotoNextPageByUser(User user);
    void toastMsg(String message);
}
