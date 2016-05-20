package com.thinkcoo.mobile.injector.components;

import com.thinkcoo.mobile.injector.ActivityScope;
import com.thinkcoo.mobile.injector.modules.AccountModule;
import com.thinkcoo.mobile.injector.modules.ApiModule;
import com.thinkcoo.mobile.model.entity.Account;
import com.thinkcoo.mobile.model.entity.User;
import com.thinkcoo.mobile.presentation.views.activitys.LoginActivity;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Administrator on 2016/5/20.
 */
@Component(dependencies = ApplicationComponent.class , modules = {AccountModule.class})
@ActivityScope
public interface AccountComponent {
    void inject(LoginActivity loginActivity);
}
