package com.thinkcoo.mobile.injector.modules;

import com.thinkcoo.mobile.domain.account.LoginUseCase;
import com.thinkcoo.mobile.injector.ActivityScope;
import com.thinkcoo.mobile.model.repository.AccountRepository;
import com.thinkcoo.mobile.model.repository.impl.AccountRepositoryImpl;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by Administrator on 2016/5/20.
 */
@Module
public class AccountModule {

    @Provides
    @ActivityScope
    LoginUseCase provideLoginUseCase(AccountRepositoryImpl repository, @Named(ApplicationModule.UI_THREAD_NAMED) Scheduler uiThread, @Named(ApplicationModule.EXECUTOR_THREAD_NAMED) Scheduler executorThread){
        return new LoginUseCase(uiThread,executorThread,repository);
    }

}
