package me.joy.architecture.interceptor;

/**
 * Created by Joy on 2019/6/10
 */
public class LoginReducer implements Reducer<LoginAction, LoginState> {

  @Override
  public LoginState reduce(LoginAction action, LoginState currentState) {
    if (action instanceof LoginAction.CheckInputAction) {
      return LoginState.empty();
    } else if (action instanceof LoginAction.LoginStartAction) {
      return LoginState.start();
    } else if (action instanceof LoginAction.LoginSuccessAction) {
      return LoginState.success();
    } else if (action instanceof LoginAction.LoginFailAction) {
      return LoginState.fail();
    }

    return currentState;
  }
}
