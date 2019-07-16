package me.joy.architecture.redux;

import java.util.Map;
import me.joy.architecture.ActionTypes;
import me.joy.architecture.redux.base.Reducer;
import me.joy.architecture.redux.data.UserData;
import me.joy.architecture.redux.base.BaseAction;

/**
 * Created by Joy on 2019/6/10
 */
public class LoginPageReducer implements Reducer<LoginPageState, BaseAction> {

  @Override
  public LoginPageState reduce(LoginPageState state, BaseAction action) {
    state.setRegisterSuccess(false);
    state.setLoginFail(false);
    state.setUserData(null);
    String type = action.getType();
    switch (type) {
      case ActionTypes.ACTION_LOGIN:
        Map<String, Object> params = action.getParams();
        String userName = (String) params.get("userName");
        String pwd = (String) params.get("pwd");
        if ("jim".equals(userName) && "123456".equals(pwd)) {
          UserData userData = new UserData(userName, pwd);
          state.setUserData(userData);
        } else {
          state.setLoginFail(true);
        }
        break;
      case ActionTypes.ACTION_REGISTER:
        state.setRegisterSuccess(true);
      default:
        break;
    }
    return state;
  }
}
