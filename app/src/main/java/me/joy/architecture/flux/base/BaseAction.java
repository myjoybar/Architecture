package me.joy.architecture.flux.base;

/**
 * Created by Joy on 2019/6/6
 */
public class BaseAction<T> {

  private final T data;

  public BaseAction(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }
}
