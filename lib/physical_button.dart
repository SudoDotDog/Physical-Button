import 'dart:async';

import 'package:flutter/services.dart';

const EventChannel _volumeEventChannel =
    EventChannel('sudo.dog/physical_button/volume');

Stream<String>? _volumeEvents;

String _listenToVolumeEvent(List<double> list) {
  return list.join(',');
}

Stream<String> get volumeEvents {
  Stream<String>? volumeEvents = _volumeEvents;
  if (volumeEvents == null) {
    volumeEvents = _volumeEventChannel.receiveBroadcastStream().map(
          (dynamic event) => _listenToVolumeEvent(event.cast<double>()),
        );
    _volumeEvents = volumeEvents;
  }

  return volumeEvents;
}
