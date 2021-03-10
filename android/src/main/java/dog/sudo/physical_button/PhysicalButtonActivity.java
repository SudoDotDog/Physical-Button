package dog.sudo.physical_button;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class PhysicalButtonActivity extends FlutterActivity {
    private static final String VOLUME_CHANNEL_NAME = "sudo.dog/physical_button/volume";

    private MethodChannel methodChannel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        System.out.println("Hello World");
        super.onCreate(savedInstanceState, persistentState);
        BinaryMessenger binaryMessenger = this.getFlutterEngine().getDartExecutor().getBinaryMessenger();
        this.methodChannel = new MethodChannel(binaryMessenger, VOLUME_CHANNEL_NAME);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        this.methodChannel.invokeMethod("PHYSICAL", "HELLO");
        return super.onKeyUp(keyCode, event);
    }
}
