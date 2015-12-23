## ExtraDimensions

This module allows you to access additional display metrics on Android devices.

- Actual width and height of the screen (including elements such as soft menu bar)
- Soft menu height
- Status bar height

### Installation

1. In `android/setting.gradle`

    ```
    ...
    include ':ExtraDimensions', ':app'
    project(':ExtraDimensions').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-extra-dimensions-android/android')
    ```

2. In `android/app/build.gradle`

    ```
    ...
    dependencies {
        ...
        compile project(':ExtraDimensions')
    }
    ```

3. Register module (in MainActivity.java)

    ```
    import ca.jaysoo.extradimensions.ExtraDimensionsPackage;  // <--- import

    public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
      ......

      @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);

        mReactInstanceManager = ReactInstanceManager.builder()
          .setApplication(getApplication())
          .setBundleAssetName("index.android.bundle")
          .setJSMainModuleName("index.android")
          .addPackage(new MainReactPackage())
          .addPackage(new ExtraDimensionsPackage(this))              // <------ add here
          .setUseDeveloperSupport(BuildConfig.DEBUG)
          .setInitialLifecycleState(LifecycleState.RESUMED)
          .build();

        mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

        setContentView(mReactRootView);
      }

      ......

    }
    ```

Whenever you want to use it within React Native code now you can:
`var ExtraDimensions = require('react-native-extra-dimensions-android');`

### Demo

![](./demo.png)

### API

There is only one method `get(dimension: string)` that takes in a dimension name, and returns its value as a `number`.
 
Supported dimensions are:

- `REAL_WINDOW_HEIGHT` - Actual height of screen including system decor elements
- `REAL_WINDOW_WIDTH` - Actual width of screen including system decor elements
- `STATUS_BAR_HEIGHT` - Height of the status bar
- `SOFT_MENU_BAR_HEIGHT` - Height of the soft menu bar (supported on most new Android devices)
