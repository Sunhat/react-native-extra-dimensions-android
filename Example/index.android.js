
'use strict';

const React = require('react-native');
const {
  AppRegistry,
  Dimensions,
  Text,
  View
} = React;

const ExtraDimensions = require('react-native-extra-dimensions-android');

const window = Dimensions.get('window');

const Example = React.createClass({
  render() {
    return (
      <View style={{ flex: 1 }}>
        <View style={{ backgroundColor: 'red', justifyContent: 'center', alignItems: 'center', height: ExtraDimensions.get('STATUS_BAR_HEIGHT')}}>
          <Text style={{ color: 'white' }}>STATUS_BAR_HEIGHT ({ExtraDimensions.get('STATUS_BAR_HEIGHT')})</Text>
        </View>
        <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
          <Text>REAL_WINDOW_HEIGHT ({ExtraDimensions.get('REAL_WINDOW_HEIGHT')})</Text>
        </View>
        <View style={{ backgroundColor: 'blue', justifyContent: 'center', alignItems: 'center', height: ExtraDimensions.get('SOFT_MENU_BAR_HEIGHT')}}>
          <Text style={{ color: 'white' }}>SOFT_MENU_BAR_HEIGHT ({ExtraDimensions.get('SOFT_MENU_BAR_HEIGHT')})</Text>
        </View>
      </View>
    );
  }
});

AppRegistry.registerComponent('Example', () => Example);
