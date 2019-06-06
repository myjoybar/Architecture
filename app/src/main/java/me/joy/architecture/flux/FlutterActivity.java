package me.joy.architecture.flux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import me.joy.architecture.R;
import me.joy.architecture.flux.base.BaseAction;
import me.joy.architecture.flux.base.BaseStore;
import me.joy.architecture.flux.dispatcher.Dispatcher;
import me.joy.architecture.flux.base.IDataChangedListener;

public class FlutterActivity extends AppCompatActivity  {

  private BaseStore store;

  public static void launch(Context context) {
    Intent intent = new Intent(context, FlutterActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flutter);
    init();
    initListener();

  }

  private void init() {
    store = new FirstStore(new IDataChangedListener() {
      @Override
      public void onDataChanged(Object obj) {
        Toast.makeText(FlutterActivity.this,"I receive a action = "+((BaseAction)obj).getData().toString(), Toast.LENGTH_LONG).show();
      }
    });
    Dispatcher.getInstance().register(store);
  }

  private void initListener() {
    findViewById(R.id.btn_getdata).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Dispatcher.getInstance().dispatch(new FirstAction("first message"));
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Dispatcher.getInstance().unregister(store);
  }


}
