package me.joy.architecture.interceptor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;
import me.joy.architecture.R;

public class InterceptorActivity extends AppCompatActivity {

  Store<LoginAction,LoginState> store;

  public static void launch(Context context) {
    Intent intent = new Intent(context, InterceptorActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flutter);
    initListener();
    CheckInputInterceptor<LoginAction,LoginState> checkInputInterceptor = new CheckInputInterceptor(InterceptorActivity.this,"jim","123456");

    List<Interceptor> interceptorList = new ArrayList<>();
    interceptorList.add(checkInputInterceptor);
    store = new Store<>(LoginState.empty(),new LoginReducer(), interceptorList);

  }

  private void initListener() {
    findViewById(R.id.btn_login).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        store.dispatch(new LoginAction.CheckInputAction());
      }
    });

    findViewById(R.id.btn_register).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });

  }



  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }
}
