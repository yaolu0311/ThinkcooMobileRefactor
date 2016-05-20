package com.thinkcoo.mobile.model.repository.impl;

import com.thinkcoo.mobile.model.db.AccountDao;
import com.thinkcoo.mobile.model.entity.Account;
import com.thinkcoo.mobile.model.entity.License;
import com.thinkcoo.mobile.model.entity.User;
import com.thinkcoo.mobile.model.entity.Vcode;
import com.thinkcoo.mobile.model.repository.AccountRepository;
import com.thinkcoo.mobile.model.rest.ApiFactory;
import com.thinkcoo.mobile.model.rest.ApiFactoryImpl;
import com.thinkcoo.mobile.model.rest.apis.AccountApi;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Administrator on 2016/5/19.
 */
public class AccountRepositoryImpl implements AccountRepository {

    @Inject
    AccountDao accountDao;
    @Inject
    AccountApi accountApi;

    @Inject
    public AccountRepositoryImpl(AccountDao accountDao, AccountApi accountApi) {
        this.accountDao = accountDao;
        this.accountApi = accountApi;
    }
    @Override
    public Observable<User> login(Account account) {
        return accountApi.login(account.getAccountName(),account.getPassword());
    }
    @Override
    public Observable logout(Account account) {
        return  null;
    }
    @Override
    public Observable register(Account account, Vcode vcode, License license) {
        return null;
    }
    @Override
    public Observable gotPassword(Account account, Vcode vcode) {
        return null;
    }

    @Override
    public Observable changePassword(Account account) {
        return null;
    }

    @Override
    public Observable changeAccountName(Account account) {
         return null;
    }

}
