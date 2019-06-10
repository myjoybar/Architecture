package me.joy.architecture.flux.base;

/**
 * Created by Joy on 2019/6/6
 *
 */
public abstract class BaseStore {


  protected OnDataFlowBackListener onDataFlowBackListener;


  public void setOnDataFlowBackListener(
      OnDataFlowBackListener onDataFlowBackListener) {
    this.onDataFlowBackListener = onDataFlowBackListener;
  }

  public void release() {
    this.onDataFlowBackListener = null;
  }


  public abstract void onReceiveAction(BaseAction baseAction);

}
