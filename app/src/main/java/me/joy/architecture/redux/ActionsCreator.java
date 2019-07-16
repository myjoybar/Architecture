package me.joy.architecture.redux;

import android.text.TextUtils;
import me.joy.architecture.redux.base.BaseAction;
import me.joy.architecture.utils.CheckUtils;

/**
 * Created by Joy on 2019/6/10
 */
public class ActionsCreator {

  private static final String TAG = "ActionsCreator";

  private static final class ActionsCreatorHolder {
    public static final ActionsCreator INSTANCE = new ActionsCreator();
  }

  public static ActionsCreator getInstance() {
    return ActionsCreatorHolder.INSTANCE;
  }


  public BaseAction create(String type,String userName,String pwd) {
    CheckUtils.checkNotNull(type);
    CheckUtils.checkNotNull(userName);
    CheckUtils.checkNotNull(pwd);
    BaseAction.Builder actionBuilder = BaseAction.type(type);
    actionBuilder.bundle("userName", userName);
    actionBuilder.bundle("pwd", pwd);
    return actionBuilder.build();
  }


  public BaseAction create(String type) {
    BaseAction.Builder actionBuilder = BaseAction.type(type);
    return actionBuilder.build();
  }


  boolean checkIsEmpty(String... data){
    int length = data.length;
    for (int i = 0; i < length; i++) {
      if(TextUtils.isEmpty( data[i])){
        return true;
      }
    }
    return false;
  }

}
