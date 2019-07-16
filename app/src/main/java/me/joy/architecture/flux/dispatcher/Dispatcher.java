package me.joy.architecture.flux.dispatcher;

import java.util.ArrayList;
import java.util.List;
import me.joy.architecture.flux.base.BaseAction;
import me.joy.architecture.flux.base.BaseStore;

/**
 * Created by Joy on 2019/6/6
 */
public class Dispatcher {

  private final List<BaseStore> stores = new ArrayList<>();

  private static final class DispatcherHolder {

    public static final Dispatcher INSTANCE = new Dispatcher();
  }

  public static Dispatcher getInstance() {
    return DispatcherHolder.INSTANCE;
  }


  public void register(final BaseStore store) {
    if (!stores.contains(store)) {
      stores.add(store);
    }
  }

  public void unregister(final BaseStore store) {
    stores.remove(store);
  }


  public void dispatch(BaseAction action) {
    post(action);
  }

  private void post(final BaseAction action) {
    for (BaseStore store : stores) {
      store.onReceiveAction(action);
    }
  }
}
