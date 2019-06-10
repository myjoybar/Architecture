package me.joy.architecture.flux.base;

/**
 * Created by Joy on 2019/6/6
 */
public class BaseAction {

  private String cmd;

  public BaseAction() {
  }

  public BaseAction(String cmd) {
    this.cmd = cmd;
  }

  public String getCmd() {
    return cmd;
  }
}
