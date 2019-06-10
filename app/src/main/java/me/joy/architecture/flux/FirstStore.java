package me.joy.architecture.flux;

import me.joy.architecture.flux.base.BaseAction;
import me.joy.architecture.flux.base.BaseStore;

/**
 * Created by Joy on 2019/6/6
 */
public class FirstStore extends BaseStore{



  @Override
  public void onReceiveAction(BaseAction baseAction) {

    String data = "I am the flow back data according to the first action";
    FirstActionFlowBackData firstActionFlowBackData = new FirstActionFlowBackData(data);
    if(onDataFlowBackListener != null){
      onDataFlowBackListener.onDataFlowBack(firstActionFlowBackData);
    }
  }

}
