package dog.sudo.physical_button;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

public class PhysicalButtonPlugin implements FlutterPlugin, ActivityAware {
  private static final String VOLUME_CHANNEL_NAME =
      "sudo.dog/physical_button/volume";
  
  private Context context;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    this.context = binding.getApplicationContext();
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
    Intent intent = new Intent(this.activity, PhysicalButtonActivity.class);
    this.activity.startActivity(intent);
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
  }

  @Override
  public void onDetachedFromActivity() {

  }
}
