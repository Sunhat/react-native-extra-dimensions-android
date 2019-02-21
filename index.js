const React = require('react');
var { NativeModules, Platform } = require('react-native');

if (Platform.OS === 'android') {
  module.exports = {
    get(dim) {
      const result = NativeModules.ExtraDimensions[dim];
      // If rounding down is ODD, round up. If rounding down is EVEN, round down.
      return Math.floor(result) % 2 ? Math.ceil(result) : Math.floor(result);
    }
  };
} else {
  module.exports = {
    get(dim) {
      console.warn('react-native-extra-dimensions-android is only available on Android');
      return 0;
    }
  };
}
