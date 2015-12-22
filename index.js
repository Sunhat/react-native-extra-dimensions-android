const React = require('react-native');
const { NativeModules: { ExtraDimensions }, Platform } = React;

if (Platform.OS === 'android') {
  module.exports = {
    get(dim) {
      return ExtraDimensions[dim];
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
