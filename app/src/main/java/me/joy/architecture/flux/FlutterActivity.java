package me.joy.architecture.flux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import me.joy.architecture.ActionTypes;
import me.joy.architecture.R;
import me.joy.architecture.flux.base.BaseAction;
import me.joy.architecture.flux.base.BaseFlutterActivity;
import me.joy.architecture.flux.base.OnDataFlowBackListener;
import me.joy.architecture.flux.data.UserData;
import me.joy.architecture.flux.dispatcher.Dispatcher;

public class FlutterActivity extends BaseFlutterActivity<LoginPageStore> {


  public static void launch(Context context) {
    Intent intent = new Intent(context, FlutterActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flutter);
    initListener();

  }

  private void initListener() {
    findViewById(R.id.btn_login).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        BaseAction loginAction = ActionsCreator.getInstance().create(ActionTypes.ACTION_LOGIN,((EditText) findViewById(R.id.et_username)).getText().toString(),((EditText) findViewById(R.id.et_pwd)).getText().toString());
        Dispatcher.getInstance().dispatch(loginAction);
      }
    });

    findViewById(R.id.btn_register).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        BaseAction registerAction = ActionsCreator.getInstance().create(ActionTypes.ACTION_REGISTER);
        Dispatcher.getInstance().dispatch(registerAction);
      }
    });

  }
  @Override
  protected void initStore() {
    store = new LoginPageStore();
    store.addDataFlowBackListener(new OnDataFlowBackListener<UserData>(ActionTypes.ACTION_LOGIN) {
      @Override
      public void onDataFlowBackSuccess(UserData flowBackData) {
        Toast.makeText(FlutterActivity.this, "login success! "+flowBackData.toString(), Toast.LENGTH_LONG).show();
      }

      @Override
      public void onDataFlowBackError(Object errorObj) {
        super.onDataFlowBackError(errorObj);
        Toast.makeText(FlutterActivity.this, errorObj.toString(), Toast.LENGTH_LONG).show();
      }
    });

    store.addDataFlowBackListener(new OnDataFlowBackListener(ActionTypes.ACTION_REGISTER) {
      @Override
      public void onDataFlowBackSuccess(Object flowBackData) {
        Toast.makeText(FlutterActivity.this, flowBackData.toString(), Toast.LENGTH_LONG).show();
      }
    });
  }


}
