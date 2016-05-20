package com.thinkcoo.mobile.presentation.mvp;

import com.thinkcoo.mobile.R;
import com.thinkcoo.mobile.domain.login.InitUserEnvironmentUseCase;
import com.thinkcoo.mobile.domain.login.UserLoginUseCase;
import com.thinkcoo.mobile.model.entity.User;
import com.thinkcoo.mobile.model.exception.InitUserEnvironmentException;
import com.thinkcoo.mobile.model.exception.PhoneNumberOrPasswordErrorException;
import com.thinkcoo.mobile.presentation.ErrorMessageFactory;
import com.thinkcoo.mobile.presentation.mvp.presenters.LoginPresenter;
import com.thinkcoo.mobile.presentation.mvp.views.LoginView;
import com.thinkcoo.mobile.utils.InputCheckUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;
import static org.mockito.Mockito.*;

/**
 * Created by Robert.yao on 2016/3/28.
 */
public class TestLoginPresenter {

    LoginPresenter tLoginPresenter;

    User user;

    @Mock
    UserLoginUseCase mockUserLoginUseCase;
    @Mock
    InitUserEnvironmentUseCase mockInitUserEnvironmentUseCase;
    @Mock
    InputCheckUtil mockInputCheckUtil;
    @Mock
    ErrorMessageFactory mockErrorMessageFactory;
    @Mock
    LoginView mockLoginView;
    @Captor
    private ArgumentCaptor<Subscriber> mUserLoginSubscriber;
    @Captor
    private ArgumentCaptor<Subscriber> mInitUserEnvironmentSubscriber;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        tLoginPresenter = new LoginPresenter(mockUserLoginUseCase,mockInitUserEnvironmentUseCase,mockInputCheckUtil,mockErrorMessageFactory);
        tLoginPresenter.attachView(mockLoginView);
        user = getFakeUser();

    }

    @Test
    public void testLoginAndInitUserEnvironmentSuccess(){
        makeLoginSuccess();
        makeInitUserEnvironmentSuccess();
    }

    @Test
    public void testLoginHappenException(){

        tLoginPresenter.login();
        verify(mockLoginView).showProgressDialog(R.string.loading);
        verify(mockUserLoginUseCase,times(1)).execute(mUserLoginSubscriber.capture());
        mUserLoginSubscriber.getValue().onError(getPhoneNumberOrPasswordErrorException());
        verify(mockLoginView).hideProgressDialogIfShowing();
        verify(mockLoginView).showToast(mockErrorMessageFactory.createStringResId(getPhoneNumberOrPasswordErrorException()));

    }

    @Test
    public void testLoginSuccessButInitUserEnvironmentFailure(){
        makeLoginSuccess();
        makeInitUserEnvironmentFailure();
    }

    private Throwable getPhoneNumberOrPasswordErrorException(){
        return new PhoneNumberOrPasswordErrorException();
    }

    private User getFakeUser(){
        User user = new User();
        return user;
    }

    private void makeLoginSuccess(){

        tLoginPresenter.login();
        verify(mockLoginView).showProgressDialog(R.string.loading);
        verify(mockUserLoginUseCase,times(1)).execute(mUserLoginSubscriber.capture());
        mUserLoginSubscriber.getValue().onNext(user);

    }

    private void makeInitUserEnvironmentSuccess(){

        verify(mockInitUserEnvironmentUseCase).setUser(eq(user));
        verify(mockInitUserEnvironmentUseCase, times(1)).execute(mInitUserEnvironmentSubscriber.capture());
        mInitUserEnvironmentSubscriber.getValue().onNext(true);
        verify(mockLoginView).hideProgressDialogIfShowing();
        verify(mockLoginView).gotoHomePage();
    }

    private void makeInitUserEnvironmentFailure(){

        verify(mockInitUserEnvironmentUseCase).setUser(eq(user));
        verify(mockInitUserEnvironmentUseCase, times(1)).execute(mInitUserEnvironmentSubscriber.capture());
        mInitUserEnvironmentSubscriber.getValue().onError(getInitUserEnvironmentException());
        verify(mockLoginView).hideProgressDialogIfShowing();
        verify(mockLoginView).showToast(mockErrorMessageFactory.createStringResId(getInitUserEnvironmentException()));

    }

    private Throwable getInitUserEnvironmentException(){
        return new InitUserEnvironmentException();
    }
}
