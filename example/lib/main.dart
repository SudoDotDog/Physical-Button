import 'package:flutter/material.dart';
import 'package:physical_button/physical_button.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _volumeValues;

  @override
  void initState() {
    super.initState();
    startPhysicalListen();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text(this._volumeValues != null ? this._volumeValues : "null"),
        ),
      ),
    );
  }
}
