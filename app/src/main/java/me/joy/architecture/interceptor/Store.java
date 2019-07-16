package me.joy.architecture.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Joy on 2019/6/10
 */
public class Store<A, S>  {

  private final Reducer<A, S> mReducer;
  private List<StateHandler<S>> mStateHanlders = Collections.synchronizedList(new LinkedList<StateHandler<S>>());
  private S mState;
  private List<Interceptor> mMiddlewares = new ArrayList<>();


  public Store( S initState, Reducer<A, S> reducer, List<Interceptor> progressInterceptors) {
    if (initState == null) throw new NullPointerException("initState can not be null");
    if (reducer == null) throw new NullPointerException("reducer can not be null");
    mState = initState;
    mReducer = reducer;
    mMiddlewares.add(new NotifySubscribersMiddleware());
    if (progressInterceptors != null && progressInterceptors.size() > 0) {
      mMiddlewares.addAll(progressInterceptors);
    }

    mMiddlewares.add(new CallReducerMiddleware());
  }


  public void dispatch(final A action) {
    handle(action);
  }


  public void addStateHandler(StateHandler stateHandler) {
    mStateHanlders.add(stateHandler);
  }

  public void removeStateHanlder(StateHandler stateHandler) {
    mStateHanlders.remove(stateHandler);
  }

  public S getState() {
    return mState;
  }


  List<Interceptor> getMiddlewares() {
    return mMiddlewares;
  }



  private void handle(A action) {
    new RealInterceptorChain<>(this, 0, action).proceed(action);
  }

  private class NotifySubscribersMiddleware implements Interceptor<A, S> {

    @Override
    public void intercept(Chain<A, S> chain) {
      chain.proceed(chain.getAction());

      dispatchState(chain.getState());
    }
  }


  private void dispatchState(S state) {
    for (StateHandler<S> stateHandler: mStateHanlders) {
      stateHandler.onNext(state);
    }
  }


  private class CallReducerMiddleware implements Interceptor<A, S> {

    @Override
    public void intercept(Chain<A, S> chain) {
      mState = reduce(chain.getAction(), mState);
    }
  }


  private S reduce(A action, S currentState) {
    return mReducer.reduce(action, currentState);
  }


}
