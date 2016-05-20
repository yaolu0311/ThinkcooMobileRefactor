package com.thinkcoo.mobile.model.rest.apis;

import com.thinkcoo.mobile.model.entity.User;

import org.androidannotations.annotations.rest.Post;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/19.
 */
public interface AccountApi {
    @Post("applogin.json")
    Observable<User> login(@Query("phoneNumber") String phoneNumber, @Query("password") String passWord);
}
