package com.thinkcoo.mobile;

import android.app.Application;
import com.thinkcoo.mobile.injector.components.ApplicationComponent;
import com.thinkcoo.mobile.model.rest.ApiFactory;

/**
 * Created by Administrator on 2016/3/16.
 */
public class ThinkcooApp extends Application{

    private ThinkcooAppInitDelegate mThinkcooAppInitDelegate;

    @Override
    public void onCreate() {
        super.onCreate();
        appInit();
    }
    private void appInit() {
        mThinkcooAppInitDelegate = new ThinkcooAppInitDelegate(this);
        mThinkcooAppInitDelegate.init();
    }
    public ApplicationComponent getApplicationComponent() {
        return mThinkcooAppInitDelegate.getmApplicationComponent();
    }
    public ApiFactory getApiFactory() {
        return mThinkcooAppInitDelegate.getApiFactory();
    }
}