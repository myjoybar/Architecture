package me.joy.architecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import me.joy.architecture.flux.FlutterActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.btn_flutter).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {

    int id = v.getId();
    switch (id) {
      case R.id.btn_flutter:
        FlutterActivity.launch(MainActivity.this);

        break;
      default:

        break;
    }
  }
}
