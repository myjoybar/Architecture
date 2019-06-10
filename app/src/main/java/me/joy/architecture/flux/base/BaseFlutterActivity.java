package me.joy.architecture.flux.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import me.joy.architecture.flux.dispatcher.Dispatcher;

/**
 * Created by Joy on 2019/6/10
 */
public abstract class BaseFlutterActivity<Store extends BaseStore> extends
    AppCompatActivity implements OnDataFlowBackListener {

  protected Store store;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initStore();
    registerStore();
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    unRegisterStore();
  }

  private void registerStore() {
    if (null != store) {
      Dispatcher.getInstance().register(store);
    }
  }


  private void unRegisterStore() {
    if (null != store && isHandleRegisterStore()) {
      store.release();
      Dispatcher.getInstance().unregister(store);
    }
  }

  protected boolean isHandleRegisterStore() {
    return true;
  }

  protected abstract void initStore();

  @Override
  public void onDataFlowBack(Object flowBackData) {

  }
}
