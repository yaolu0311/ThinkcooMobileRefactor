package com.thinkcoo.mobile.model.exception;


import com.thinkcoo.mobile.model.rest.ServerResponse;

/**
 * Created by Robert.yao on 2016/3/22.
 */
public class YzApiExceptionFactory {

    public static Exception create(ServerResponse serverResponse) {
        return new Exception("yzkj server error");
    }
}
