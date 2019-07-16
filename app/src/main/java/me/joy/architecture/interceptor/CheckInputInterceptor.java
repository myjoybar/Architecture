package me.joy.architecture.interceptor;

import android.content.Context;
import me.joy.architecture.utils.CheckUtils;

/**
 * Created by Joy on 2019/6/10
 */
public class CheckInputInterceptor<A, S> implements Interceptor<A, S> {


  private Context context;
  private String userName;
  private String pwd;

  public CheckInputInterceptor(Context context, String userName, String pwd) {
    this.context = context;
    this.userName = userName;
    this.pwd = pwd;
  }

  @Override
  public void intercept(Chain<A, S> chain) {
    CheckUtils.checkNotNull(userName, pwd);
    chain.proceed(chain.getAction());
  }
}
