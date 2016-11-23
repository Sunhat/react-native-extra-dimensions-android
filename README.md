## ExtraDimensions

This module allows you to access additional display metrics on Android devices. (RN 0.29.0+)

- Actual width and height of the screen (including elements such as soft menu bar)
- Soft menu height
- Status bar height
- Smart bar height (MeiZu)


### Why?

There is currently a bug in React Native where [`Dimensions.get('window').height` sometimes returns
the wrong value](https://github.com/facebook/react-native/issues/4934).

Also, some apps may want to set the background of status bar and soft menu bar to transparent, thus the top-level
view needs to fill up the real screen size.

### Installation

1. Install with npm
   ```
   npm install react-native-extra-dimensions-android --save
   ```
   
2. link using rnpm

    ```
    rnpm link react-native-extra-dimensions-android
    ```

3. You may have to register the module (in android/app/src/main/java/com/YOUR-PROJECT-NAME/MainApplication.java)


    ```
    import ca.jaysoo.extradimensions.ExtraDimensionsPackage;  // <--- import

    public class MainApplication extends Application implements ReactApplication {
      ......
      protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new ExtraDimensionsPackage()  // <--- add here
        );
      }
      ......
    }
    ```
    
4. Whenever you want to use it within React Native code now you can:

`var ExtraDimensions = require('react-native-extra-dimensions-android');`

Or, if you are using ES6

`import ExtraDimensions from 'react-native-extra-dimensions-android';`

### Demo

![](./demo.png)

### API

There is only one method `get(dimension: string)` that takes in a dimension name, and returns its value as a `number`.
 
Supported dimensions are:

- `REAL_WINDOW_HEIGHT` - Actual height of screen including system decor elements
- `REAL_WINDOW_WIDTH` - Actual width of screen including system decor elements
- `STATUS_BAR_HEIGHT` - Height of the status bar
- `SOFT_MENU_BAR_HEIGHT` - Height of the soft menu bar (supported on most new Android devices)
- `SMART_BAR_HEIGHT` - Height of the MeiZu's device smart bar
