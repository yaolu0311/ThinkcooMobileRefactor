package com.thinkcoo.mobile.presentation.mvp;

import com.thinkcoo.mobile.domain.register.CheckVerifyCodeUseCase;
import com.thinkcoo.mobile.domain.register.GetVerifyCodeUseCase;
import com.thinkcoo.mobile.model.entity.CheckVerifyCodePackParam;
import com.thinkcoo.mobile.model.entity.FindPasswordToken;
import com.thinkcoo.mobile.model.entity.VerifyCode;
import com.thinkcoo.mobile.presentation.ErrorMessageFactory;
import com.thinkcoo.mobile.presentation.mvp.views.RequestFindPasswordView;
import com.thinkcoo.mobile.utils.InputCheckUtil;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;
import static org.mockito.Mockito.*;

/**
 * Created by Robert.yao on 2016/3/31.
 */
public class TestRequestFindPassWordPresenter {


    //被测对象
    RequestFindPasswordPresenter tRequestFindPasswordPresenter;

    //参与测试对象
    @Mock
    GetVerifyCodeUseCase mockGetVerifyCodeUseCase;
    @Mock
    CheckVerifyCodeUseCase mockCheckVerifyCodeUseCase;
    @Mock
    ErrorMessageFactory mockErrorMessageFactory;
    @Mock
    InputCheckUtil mockInputCheckUtil;
    @Mock
    RequestFindPasswordView mockRequestFindPasswordView;
    @Captor
    private ArgumentCaptor<Subscriber> mGetVerifyCodeSubscriber;
    @Captor
    private ArgumentCaptor<Subscriber> mCheckVerifyCodeSubscriber;


    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);

        tRequestFindPasswordPresenter = new RequestFindPasswordPresenter(
                mockGetVerifyCodeUseCase,
                mockCheckVerifyCodeUseCase,
                mockErrorMessageFactory,
                mockInputCheckUtil
        );
        tRequestFindPasswordPresenter.attachView(mockRequestFindPasswordView);
    }

    @Test
    public void testGetVerifyCodeSuccess(){

        getVerifyCodeCheckPassAndRunUseCase();
        mGetVerifyCodeSubscriber.getValue().onNext(VerifyCode.NULL_VERIFYCODEINFO);
        Assert.assertTrue(tRequestFindPasswordPresenter.isVerifyCodeGot());

    }

    @Test
    public void testUseCaseDestroy(){
        tRequestFindPasswordPresenter.detachView(false);
        verify(mockGetVerifyCodeUseCase, times(1)).unsubscribe();
        verify(mockCheckVerifyCodeUseCase,times(1)).unsubscribe();
    }

    @Test
    public void testGetVerifyCodeCheckPhoneNumberFailure(){
        when(mockInputCheckUtil.checkPhoneNumber(anyString())).thenReturn(false);
        tRequestFindPasswordPresenter.getVerifyCode();
        verify(mockRequestFindPasswordView).showToast(anyInt());
    }

    @Test
    public void testGetVerifyCodeFailure(){

        getVerifyCodeCheckPassAndRunUseCase();
        mGetVerifyCodeSubscriber.getValue().onError(any(Throwable.class));
        verify(mockRequestFindPasswordView, times(1)).stopGetVerifyCodeCountDown();
        verify(mockRequestFindPasswordView,times(1)).showToast(anyInt());
        Assert.assertFalse(tRequestFindPasswordPresenter.isVerifyCodeGot());

    }

    @Test
    public void testCheckVerifyCodeSuccess(){

        when(mockInputCheckUtil.checkPhoneNumber(anyString())).thenReturn(true);
        when(mockInputCheckUtil.checkVerifyCode(anyString())).thenReturn(true);
        tRequestFindPasswordPresenter.setVerifyCode(VerifyCode.NULL_VERIFYCODEINFO);

        tRequestFindPasswordPresenter.checkVerifyCode();
        verify(mockRequestFindPasswordView,times(1)).showProgressDialog(anyInt());
        verify(mockCheckVerifyCodeUseCase).setCheckVerifyCodePackParam(any(CheckVerifyCodePackParam.class));
        verify(mockCheckVerifyCodeUseCase).execute(mCheckVerifyCodeSubscriber.capture());

        mCheckVerifyCodeSubscriber.getValue().onNext(FindPasswordToken.NULL_FINDPASSWORDTOKEN);
        verify(mockRequestFindPasswordView).hideProgressDialogIfShowing();
        verify(mockRequestFindPasswordView).gotoCompleteFindPasswordPage(FindPasswordToken.NULL_FINDPASSWORDTOKEN);
    }

    @Test
    public void testCheckVerifyCodeFailure(){

        when(mockInputCheckUtil.checkPhoneNumber(anyString())).thenReturn(true);
        when(mockInputCheckUtil.checkVerifyCode(anyString())).thenReturn(true);
        tRequestFindPasswordPresenter.setVerifyCode(VerifyCode.NULL_VERIFYCODEINFO);

        tRequestFindPasswordPresenter.checkVerifyCode();
        verify(mockRequestFindPasswordView,times(1)).showProgressDialog(anyInt());
        verify(mockCheckVerifyCodeUseCase).setCheckVerifyCodePackParam(any(CheckVerifyCodePackParam.class));
        verify(mockCheckVerifyCodeUseCase).execute(mCheckVerifyCodeSubscriber.capture());

        mCheckVerifyCodeSubscriber.getValue().onError(any(Throwable.class));
        verify(mockRequestFindPasswordView).hideProgressDialogIfShowing();
        verify(mockRequestFindPasswordView).showToast(anyInt());
    }

    private void getVerifyCodeCheckPassAndRunUseCase(){

        when(mockInputCheckUtil.checkPhoneNumber(anyString())).thenReturn(true);

        tRequestFindPasswordPresenter.getVerifyCode();

        verify(mockInputCheckUtil , times(1)).checkPhoneNumber(anyString());
        verify(mockRequestFindPasswordView, times(2)).getPhoneNumber();
        verify(mockRequestFindPasswordView, times(1)).startGetVerifyCodeCountDown();
        verify(mockGetVerifyCodeUseCase, times(1)).execute(mGetVerifyCodeSubscriber.capture());

    }
}
