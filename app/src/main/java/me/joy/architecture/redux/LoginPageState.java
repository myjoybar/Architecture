package me.joy.architecture.redux;

import me.joy.architecture.redux.base.state;
import me.joy.architecture.redux.data.UserData;

/**
 * Created by Joy on 2019/6/10
 */
public class LoginPageState implements state {
  private UserData userData;
  private boolean loginFail;
  private boolean registerSuccess;

  public UserData getUserData() {
    return userData;
  }

  public void setUserData(UserData userData) {
    this.userData = userData;
  }

  public boolean isLoginFail() {
    return loginFail;
  }

  public void setLoginFail(boolean loginFail) {
    this.loginFail = loginFail;
  }

  public boolean isRegisterSuccess() {
    return registerSuccess;
  }

  public void setRegisterSuccess(boolean registerSuccess) {
    this.registerSuccess = registerSuccess;
  }


}
