package me.joy.architecture.interceptor;

/**
 * Created by Joy on 2019/6/10
 */
public interface LoginAction {

  class CheckInputAction implements LoginAction{

  }

  class LoginStartAction implements LoginAction{

  }

  class LoginSuccessAction implements LoginAction{

  }

  class LoginFailAction implements LoginAction{

  }
}
