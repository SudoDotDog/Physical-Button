import 'package:flutter/services.dart';

void startPhysicalListen() {
  final String channelName = "sudo.dog/physical_button/volume";
  final MethodChannel methodChannel = MethodChannel(channelName);
  methodChannel.setMethodCallHandler((MethodCall call) async {
    print(call);
  });
}
