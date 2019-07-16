package me.joy.architecture.flux;

import java.util.Map;
import me.joy.architecture.ActionTypes;
import me.joy.architecture.flux.base.BaseAction;
import me.joy.architecture.flux.base.BaseStore;
import me.joy.architecture.flux.base.OnDataFlowBackListener;
import me.joy.architecture.flux.data.UserData;

/**
 * Store模块包含了App状态和业务逻辑
 * 保存应用的状态并提供一些帮助方法来存取状态，分发状态以及注册监听。
 * Created by Joy on 2019/6/6
 */
public class LoginPageStore extends BaseStore {

  @Override
  public void onReceiveAction(BaseAction baseAction) {

    String type = baseAction.getType();
    OnDataFlowBackListener dataFlowBackListener = getDataFlowBackListener(type);
    switch (type) {
      case ActionTypes.ACTION_LOGIN:


          Map<String, Object> params = baseAction.getParams();
          String userName = (String) params.get("userName");
          String pwd = (String) params.get("pwd");

          if ("jim".equals(userName) && "123456".equals(pwd)) {
            UserData userData = new UserData(userName, pwd);
            if (dataFlowBackListener != null) {
              dataFlowBackListener.onDataFlowBackSuccess(userData);
            }
          } else {
            if (dataFlowBackListener != null) {
              dataFlowBackListener.onDataFlowBackError("userName or pwd is wrong");
            }
        }
        break;
      case ActionTypes.ACTION_REGISTER:
        if (dataFlowBackListener != null) {
          dataFlowBackListener
              .onDataFlowBackSuccess("Register success! You can login with jim and 123456");
        }
        break;
      default:
        break;
    }

  }

}
