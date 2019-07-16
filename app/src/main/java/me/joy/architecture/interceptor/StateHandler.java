package me.joy.architecture.interceptor;

/**
 * Created by yangwei-os on 2017/11/14.
 */

public abstract class StateHandler<S> {

    public void onNext(final S next) {
        handle(next);
    }

    public abstract void handle(S next);
}
