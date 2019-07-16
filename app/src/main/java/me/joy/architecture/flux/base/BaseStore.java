package me.joy.architecture.flux.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Store模块包含了App状态和业务逻辑 Created by Joy on 2019/6/6
 */
public abstract class BaseStore {

  List<OnDataFlowBackListener> onDataFlowBackListeners;


  public void addDataFlowBackListener(OnDataFlowBackListener onDataFlowBackListener) {
    if (null == onDataFlowBackListeners) {
      onDataFlowBackListeners = new ArrayList<>();
    }
    onDataFlowBackListeners.add(onDataFlowBackListener);
  }

  public void release() {
    if (null != onDataFlowBackListeners) {
      onDataFlowBackListeners.clear();
      onDataFlowBackListeners = null;
    }
  }

  public abstract void onReceiveAction(BaseAction baseAction);


  public OnDataFlowBackListener getDataFlowBackListener(String type) {
    int size;
    if (null != onDataFlowBackListeners && ((size = onDataFlowBackListeners.size())) != 0) {
      for (int i = 0; i < size; i++) {
        OnDataFlowBackListener dataFlowBackListener = onDataFlowBackListeners.get(i);
        if (type.equals(dataFlowBackListener.type)) {
          return dataFlowBackListener;
        }
      }

    }
    return null;
  }


}
