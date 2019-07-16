package me.joy.architecture.redux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import me.joy.architecture.ActionTypes;
import me.joy.architecture.R;
import me.joy.architecture.redux.base.BaseAction;
import me.joy.architecture.redux.data.UserData;
import me.joy.architecture.redux.base.Observer;

public class ReduxActivity extends AppCompatActivity implements Observer {

  LoginPageStore loginPageStore;

  public static void launch(Context context) {
    Intent intent = new Intent(context, ReduxActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flutter);
    initListener();
    loginPageStore = new LoginPageStore(new LoginPageReducer());

  }

  private void initListener() {
    findViewById(R.id.btn_login).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        BaseAction loginAction = ActionsCreator
            .getInstance().create(ActionTypes.ACTION_LOGIN,
                ((EditText) findViewById(R.id.et_username)).getText().toString(),
                ((EditText) findViewById(R.id.et_pwd)).getText().toString());

        loginPageStore.dispatch(loginAction);
      }
    });

    findViewById(R.id.btn_register).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        BaseAction registerAction = ActionsCreator.getInstance()
            .create(ActionTypes.ACTION_REGISTER);
        loginPageStore.dispatch(registerAction);
      }
    });

  }


  @Override
  public void update() {
    UserData userData = loginPageStore.getState().getUserData();
    if (loginPageStore.getState().isRegisterSuccess()) {
      Toast.makeText(ReduxActivity.this, "Register success! You can login with jim and 123456",
          Toast.LENGTH_LONG).show();
    } else if (null != userData) {
      Toast.makeText(ReduxActivity.this, "login success! " + userData.toString(), Toast.LENGTH_LONG)
          .show();
    } else if (loginPageStore.getState().isLoginFail()) {
      Toast.makeText(ReduxActivity.this, "userName or pwd is wrong", Toast.LENGTH_LONG).show();
    }

  }

  @Override
  protected void onStop() {
    super.onStop();
    loginPageStore.unSubscribe(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    loginPageStore.subscribe(this);
  }
}
