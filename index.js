const React = require('react');
var { NativeModules, Platform } = require('react-native');

if (Platform.OS === 'android') {
  module.exports = {
    get(dim) {
      return NativeModules.ExtraDimensions[dim];
    }
  };
} else {
  console.warn('react-native-extra-dimensions-android is only available on Android');
  module.exports = {
    get(dim) {
      return 0;
    }
  };
}
