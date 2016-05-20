package com.thinkcoo.mobile.domain;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public abstract class UseCase<Q extends UseCase.RequestValues> {

    private final Scheduler mUiThread;
    private final Scheduler mExecutorThread;
    private  Q requestValues;

    private Subscription subscription = Subscriptions.empty();

    protected UseCase(Scheduler mUiThread, Scheduler mExecutorThread) {
        this.mUiThread = mUiThread;
        this.mExecutorThread = mExecutorThread;
    }

    protected abstract Observable buildUseCaseObservable();

    public void execute(Subscriber UseCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(mExecutorThread)
                .observeOn(mUiThread)
                .subscribe(UseCaseSubscriber);
    }

    public void unSubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void setRequestValues(Q requestValues){
        this.requestValues = requestValues;
    }

    public Q getRequestValues(){
        return requestValues;
    }

    public interface RequestValues {

    }
}
