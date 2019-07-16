package me.joy.architecture.flux.base;


public abstract class OnDataFlowBackListener<Data> {

  String type;

  public OnDataFlowBackListener(String type) {
    this.type = type;
  }

  public abstract void onDataFlowBackSuccess(Data flowBackData);

  public void onDataFlowBackError(Object errorObj) {

  }
}
