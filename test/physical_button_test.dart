import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:physical_button/physical_button.dart';

void main() {
  const MethodChannel channel = MethodChannel('physical_button');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await PhysicalButton.platformVersion, '42');
  });
}
