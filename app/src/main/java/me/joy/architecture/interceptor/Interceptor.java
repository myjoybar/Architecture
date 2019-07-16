package me.joy.architecture.interceptor;


/**
 * Created by Joy on 2019/6/10
 */
public interface Interceptor<A, S> {

  void intercept(Chain<A, S> chain);

  interface Chain<A, S> {
    void proceed(A action);

    S getState();

    A getAction();

    Store<A, S> getStore();
  }
}
