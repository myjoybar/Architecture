package me.joy.architecture.redux.base;

/**
 * Created by Joy on 2019/6/10
 * 进行状态的转变
 */
public interface Reducer<S, A extends BaseAction> {
   S reduce(S state, A action);
}
