
'use strict';

const React = require('react-native');
const {
  AppRegistry,
  StyleSheet,
  Text,
  View,
} = React;

const ExtraDimensions = require('react-native-extra-dimensions-android');

const Example = React.createClass({
  render: function() {
    return (
      <View style={{ flex: 1, flexDirection: 'column' }}>
        <View style={{ backgroundColor: 'blue', justifyContent: 'center', alignItems: 'center', height: ExtraDimensions.get('STATUS_BAR_HEIGHT') }}>
          <Text style={{ color: 'white' }}>STATUS_BAR_HEIGHT ({ExtraDimensions.get('STATUS_BAR_HEIGHT')})</Text>
        </View>
        <View style={{ flex: 1 }}/>
        <View style={{ backgroundColor: 'green', justifyContent: 'center', alignItems: 'center', height: ExtraDimensions.get('SOFT_MENU_BAR_HEIGHT') }}>
          <Text style={{ color: 'white' }}>SOFT_MENU_BAR_HEIGHT ({ExtraDimensions.get('SOFT_MENU_BAR_HEIGHT')})</Text>
        </View>
      </View>
    );
  }
});

AppRegistry.registerComponent('Example', () => Example);
