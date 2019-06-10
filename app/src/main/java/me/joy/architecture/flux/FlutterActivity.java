package me.joy.architecture.flux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import me.joy.architecture.R;
import me.joy.architecture.flux.base.BaseFlutterActivity;
import me.joy.architecture.flux.base.OnDataFlowBackListener;
import me.joy.architecture.flux.dispatcher.Dispatcher;

public class FlutterActivity extends BaseFlutterActivity<FirstStore> {


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

  @Override
  protected void initStore() {
    store = new FirstStore();
    store.setOnDataFlowBackListener(new OnDataFlowBackListener<FirstActionFlowBackData>() {
      @Override
      public void onDataFlowBack(FirstActionFlowBackData flowBackData) {
        Toast.makeText(FlutterActivity.this, flowBackData.getMessage(), Toast.LENGTH_LONG).show();
      }
    });
  }

  private void initListener() {
    findViewById(R.id.btn_action1).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Dispatcher.getInstance().dispatch(new FirstAction());
      }
    });


  }




}
