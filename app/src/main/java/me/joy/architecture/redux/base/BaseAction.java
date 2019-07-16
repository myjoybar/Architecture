package me.joy.architecture.redux.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy on 2019/6/6
 */
public class BaseAction {

  private String type;
  private Map<String, Object> params;

  public String getType() {
    return type;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public BaseAction() {

  }

  public BaseAction(String type, Map<String, Object> params) {
    this.type = type;
    this.params = params;
  }

  public static Builder type(String type) {
    return new Builder().with(type);
  }



  public static class Builder {

    private String type;
    private HashMap<String, Object> data;

    Builder with(String type) {
      if (type == null) {
        throw new IllegalArgumentException("Type may not be null.");
      }
      this.type = type;
      this.data = new HashMap<>();
      return this;
    }

    public Builder bundle(String key, Object value) {
      if (key == null) {
        throw new IllegalArgumentException("Key may not be null.");
      }

      if (value == null) {
        throw new IllegalArgumentException("Value may not be null.");
      }
      data.put(key, value);
      return this;
    }

    public BaseAction build() {
      if (type == null || type.isEmpty()) {
        throw new IllegalArgumentException("At least one key is required.");
      }
      return new BaseAction(type, data);
    }
  }
}


