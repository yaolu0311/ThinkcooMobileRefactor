package com.thinkcoo.mobile.model.rest.apis;

import com.thinkcoo.mobile.model.entity.User;
import retrofit.http.Query;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/19.
 */
public interface AccountApi {
    @POST("applogin.json")
    Observable<User> login(@Query("phoneNumber") String phoneNumber, @Query("password") String passWord);
}
