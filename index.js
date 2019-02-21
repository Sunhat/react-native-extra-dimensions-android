const React = require('react');
var { NativeModules, Platform } = require('react-native');

if (Platform.OS === 'android') {
  module.exports = {
    get(dim) {
      try {
        if(!NativeModules.ExtraDimensions) {
          throw "ExtraDimensions not defined. Try rebuilding your project. e.g. react-native run-android"
        }
        const result = NativeModules.ExtraDimensions[dim];

        if(typeof result !== 'number') {
            return result;
        }
        // If rounding down is ODD, round up. If rounding down is EVEN, round down.
        return Math.floor(result) % 2 ? Math.ceil(result) : Math.floor(result);
      } catch (e) {
        console.error(e)
      }
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
