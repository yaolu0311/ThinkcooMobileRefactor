package com.thinkcoo.mobile.model.rest.apis;

import com.thinkcoo.mobile.model.rest.ServerResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Robert.yao on 2016/3/22.
 */
public interface UserApi{

    @GET("applogin.json")
    Observable<ServerResponse> userLogin(@Query("phoneNumber") String phoneNumber, @Query("password") String passWord);

}
