package com.thinkcoo.mobile.model.rest;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robert.yao on 2016/3/22.
 */
public class ServerResponse {

    public static final String  TAG = "ServerResponse";
    public static  final String STATUS_OK = "1";

    private String msg;
    private String status;
    private String data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return status.equals(STATUS_OK);
    }

    public <T extends  Object> T getDataEntity(T onExceptionHappendReturnEntity) {

        Gson gson = new Gson();
        try{
            Type type = new TypeToken<T>() {}.getType();
            T t = gson.fromJson(data,type);
            return t;
        }catch (Exception e){
            Log.e(TAG,e.getMessage(),e);
            return onExceptionHappendReturnEntity;
        }

    }

    public <T extends  Object> List<T> getDataEntityList(){
        Gson gson = new Gson();
        List<T> list = null;
        try {
                list =  gson.fromJson(data,
                    new TypeToken<List<T>>() {
                    }.getType());
        }catch (Exception e) {
            Log.e(TAG,e.getMessage(),e);
        }
        return  processNullList(list);
    }

    private <T extends Object> List<T> processNullList(List<T> list) {
        if (null == list ){
            return Collections.emptyList();
        }else {
            return list;
        }
    }

}
