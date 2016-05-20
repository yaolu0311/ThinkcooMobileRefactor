package com.thinkcoo.mobile.domain.account;
import com.thinkcoo.mobile.domain.UseCase;
import com.thinkcoo.mobile.model.entity.Account;
import com.thinkcoo.mobile.model.repository.AccountRepository;
import javax.inject.Inject;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by Administrator on 2016/5/20.
 */
public class LoginUseCase extends UseCase{

    @Inject
    AccountRepository accountRepository;

    @Inject
    public LoginUseCase(Scheduler mUiThread, Scheduler mExecutorThread, AccountRepository accountRepository) {
        super(mUiThread, mExecutorThread);
        this.accountRepository = accountRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        LoginRequestValue accountRequestValue = (LoginRequestValue)getRequestValues();
        return accountRepository.login(accountRequestValue.getAccount());
    }

    public static class LoginRequestValue implements RequestValues{
        Account account ;
        public Account getAccount() {
            return account;
        }
        public void setAccount(Account account) {
            this.account = account;
        }
    }
}
