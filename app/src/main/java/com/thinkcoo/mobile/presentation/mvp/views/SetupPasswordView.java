package com.thinkcoo.mobile.presentation.mvp.views;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Robert.yao on 2016/3/30.
 */
public interface SetupPasswordView extends MvpView , BaseActivityHelpView , BaseHintView{
    String getPassword();

}
