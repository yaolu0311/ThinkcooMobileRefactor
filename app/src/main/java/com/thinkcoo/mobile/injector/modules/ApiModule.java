package com.thinkcoo.mobile.injector.modules;

import com.thinkcoo.mobile.model.rest.ApiFactory;
import com.thinkcoo.mobile.model.rest.apis.AccountApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/5/20.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public AccountApi provideAccountApi(ApiFactory apiFactory){
        return apiFactory.createApiByClass(AccountApi.class);
    }

}
