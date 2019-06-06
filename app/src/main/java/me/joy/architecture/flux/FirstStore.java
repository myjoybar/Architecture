package me.joy.architecture.flux;

import me.joy.architecture.flux.base.BaseAction;
import me.joy.architecture.flux.base.BaseStore;
import me.joy.architecture.flux.base.IDataChangedListener;

/**
 * Created by Joy on 2019/6/6
 */
public class FirstStore extends BaseStore {

  public FirstStore() {
  }

  public FirstStore(IDataChangedListener mListener) {
    super(mListener);
  }

  @Override
  public void onReceiveAction(BaseAction action) {
    if(mListener!=null){
      mListener.onDataChanged(action);
    }

  }
}
