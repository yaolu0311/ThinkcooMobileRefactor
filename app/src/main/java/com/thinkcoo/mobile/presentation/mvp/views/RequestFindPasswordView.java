package com.thinkcoo.mobile.presentation.mvp.views;

import com.thinkcoo.mobile.model.entity.FindPasswordToken;

/**
 * Created by Robert.yao on 2016/3/30.
 */
public interface RequestFindPasswordView extends VerifyCodeView {
    void gotoCompleteFindPasswordPage(FindPasswordToken findPasswordToken);
}
