package com.thinkcoo.mobile.presentation;

import android.accounts.NetworkErrorException;
import android.content.Context;
import com.thinkcoo.mobile.R;
import com.thinkcoo.mobile.model.exception.PhoneNumberOrPasswordErrorException;

import javax.inject.Inject;

public class ErrorMessageFactory {

  private Context applicationContext;

  public String create(Throwable e) {

    String message = getDefaultErrorMsg();
    if (e instanceof NetworkErrorException) {
      message = applicationContext.getString(R.string.net_no);
    }
    return message;
  }

  public int createStringResId(Throwable e){

    int message = R.string.default_error_msg;
    if (e instanceof NetworkErrorException) {
      message = R.string.net_no;
    }else if( e instanceof PhoneNumberOrPasswordErrorException){
      message = R.string.errTips_phone_pws_error;
    }
    return message;

  }

  @Inject
  public ErrorMessageFactory(Context context) {
    applicationContext = context.getApplicationContext();
  }

  public Context getContext(){
    return applicationContext;
  }

  private String getDefaultErrorMsg(){
    return applicationContext.getString(R.string.default_error_msg);
  }

  private String getString(int stringResId){
    return  applicationContext.getString(stringResId);
  }

}
