package me.joy.architecture.redux;

import java.util.ArrayList;
import java.util.List;
import me.joy.architecture.redux.base.BaseAction;
import me.joy.architecture.redux.base.Observer;
import me.joy.architecture.redux.base.Reducer;
import me.joy.architecture.redux.base.Store;

/**
 * Created by Joy on 2019/6/10
 * store 来进行分发 action
 */
public class LoginPageStore implements Store<LoginPageState> {

  private List<Observer> observers = new ArrayList<>();
  private LoginPageState currentState = new LoginPageState();
  private Reducer reducer;

  public LoginPageStore(Reducer reducer) {
    this.reducer = reducer;
  }

  @Override
  public LoginPageState getState() {
    return currentState;
  }

  @Override
  public void dispatch(BaseAction action) {
    currentState = (LoginPageState) reducer.reduce(currentState, action);
    notifyChange();
  }

  @Override
  public void subscribe(Observer object) {
    if (!observers.contains(object)){
      observers.add(object);
    }
  }

  @Override
  public void unSubscribe(Observer object) {
    observers.remove(object);
  }

  private void notifyChange() {
    for(Observer observer : observers) {
      observer.update();
    }
  }
}
