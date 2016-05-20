package com.thinkcoo.mobile.injector.components;

import android.content.Context;
import com.thinkcoo.mobile.injector.modules.ApplicationModule;
import com.thinkcoo.mobile.model.rest.ApiFactory;
import com.thinkcoo.mobile.model.rest.ApiFactoryImpl;
import com.thinkcoo.mobile.presentation.views.activitys.base.BaseActivity;
import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Component;
import rx.Scheduler;

/**
 * Created by Robert.yao on 2016/3/21.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
    Context provideApplicationContext();
    ApiFactory provideApiFactory();
    @Named(ApplicationModule.EXECUTOR_THREAD_NAMED) Scheduler provideExecutorThread();
    @Named(ApplicationModule.UI_THREAD_NAMED) Scheduler provideUiThread();
    @Named(ApplicationModule.EXECUTOR_SINGLE_THREAD_NAMED) Scheduler provideSigleThreadExecutor();

}
