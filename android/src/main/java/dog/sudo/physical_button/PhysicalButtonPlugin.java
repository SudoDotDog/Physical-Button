package dog.sudo.physical_button;

import androidx.annotation.NonNull;

import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;

public class PhysicalButtonPlugin implements FlutterPlugin {
  private static final String VOLUME_CHANNEL_NAME =
      "sudo.dog/physical_button/volume";
  
  private EventChannel volumeChannel;

  @SuppressWarnings("deprecation")
  public static void registerWith(io.flutter.plugin.common.PluginRegistry.Registrar registrar) {
    PhysicalButtonPlugin plugin = new PhysicalButtonPlugin();
    plugin.setupEventChannels(registrar.context(), registrar.messenger());
  }

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    final Context context = binding.getApplicationContext();
    setupEventChannels(context, binding.getBinaryMessenger());
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    teardownEventChannels();
  }
  
  private void setupEventChannels(Context context, BinaryMessenger messenger) {
    volumeChannel = new EventChannel(messenger, VOLUME_CHANNEL_NAME);
    final StreamHandlerImplement volumeStreamHandler = new StreamHandlerImplement();
    volumeChannel.setStreamHandler(volumeStreamHandler);
  }
  
  private void teardownEventChannels() {
    volumeChannel.setStreamHandler(null);
  }
}
