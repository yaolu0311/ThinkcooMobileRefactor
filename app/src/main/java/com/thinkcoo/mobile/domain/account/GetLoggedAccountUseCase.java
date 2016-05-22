package com.thinkcoo.mobile.domain.account;

import com.thinkcoo.mobile.domain.UseCase;
import com.thinkcoo.mobile.model.entity.Account;
import com.thinkcoo.mobile.model.repository.AccountRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by robert on 2016/5/22.
 */
public class GetLoggedAccountUseCase extends UseCase<Void>{

    AccountRepository accountRepository;

    @Inject
    public GetLoggedAccountUseCase(Scheduler mUiThread, Scheduler mExecutorThread, AccountRepository accountRepository) {
        super(mUiThread, mExecutorThread);
        this.accountRepository = accountRepository;
    }
    @Override
    protected Observable<Account> buildUseCaseObservable(Void... q) {
        return accountRepository.getLoggedAccount();
    }

}
