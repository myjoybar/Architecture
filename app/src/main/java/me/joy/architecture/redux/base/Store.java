package me.joy.architecture.redux.base;

/**
 * Created by Joy on 2019/6/10
 */
public interface Store<T> {

  T getState();

  void dispatch(BaseAction action);

  void subscribe(Observer object);

  void unSubscribe(Observer object);
}

