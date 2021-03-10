import 'package:flutter/services.dart';

void startPhysicalListen() {
  final String channelName = 'app.sudo.land/live_and_learn/example';
  final MethodChannel methodChannel = MethodChannel(channelName);
  methodChannel.setMethodCallHandler((MethodCall call) async {
    print(call);
  });
}
