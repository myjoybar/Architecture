package me.joy.architecture.interceptor;

/**
 * Created by Joy on 2019/6/10
 */
public class LoginState {

  private String state;

  public LoginState(String state) {
    this.state = state;
  }

  public static LoginState empty(){
    return new LoginState("empty");
  }

  public static LoginState start(){
    return new LoginState("start");
  }



  public static LoginState success(){
    return new LoginState("success");
  }


  public static LoginState fail(){
    return new LoginState("fail");
  }
}
