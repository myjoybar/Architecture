package me.joy.architecture.flux.base;

/**
 * Created by Joy on 2019/6/6
 *
 */
public abstract class BaseStore {

  protected  IDataChangedListener mListener;

  public BaseStore() {
    this(null);
  }

  public BaseStore(IDataChangedListener mListener) {
    this.mListener = mListener;
  }


  public void notifyDataChanged(String label) {
    if (mListener != null) {
      mListener.onDataChanged(label);
    }
  }

  public void release() {
    this.mListener = null;
  }


  public abstract void onReceiveAction(BaseAction action);

}
