package ca.jaysoo.extradimensions;

import java.lang.Math;
import java.lang.reflect.InvocationTargetException;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;

public class ExtraDimensionsModule extends ReactContextBaseJavaModule {
    private Activity mCurrentActivity;

    public ExtraDimensionsModule(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        mCurrentActivity = activity;
    }

    @Override
    public String getName() {
        return "ExtraDimensions";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants =  new HashMap<>();

        final Context ctx = getReactApplicationContext();
        final DisplayMetrics metrics = ctx.getResources().getDisplayMetrics();

        // Get the real display metrics if we are using API level 17 or higher.
        // The real metrics include system decor elements (e.g. soft menu bar).
        //
        // See: http://developer.android.com/reference/android/view/Display.html#getRealMetrics(android.util.DisplayMetrics)
        if (Build.VERSION.SDK_INT >= 17) {
            Display display = mCurrentActivity.getWindowManager().getDefaultDisplay();
            try {
                Display.class.getMethod("getRealMetrics", DisplayMetrics.class).invoke(display, metrics);
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e) {
            } catch (NoSuchMethodException e) {
            }
        }

        constants.put("REAL_WINDOW_HEIGHT", getRealHeight(metrics));
        constants.put("REAL_WINDOW_WIDTH", getRealWidth(metrics));
        constants.put("STATUS_BAR_HEIGHT", getStatusBarHeight(metrics));
        constants.put("SOFT_MENU_BAR_HEIGHT", getSoftMenuBarHeight(metrics));

        return constants;
    }

    private float getStatusBarHeight(DisplayMetrics metrics) {
        final Context ctx = getReactApplicationContext();
        final int heightResId = ctx.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return
          heightResId > 0
            ? ctx.getResources().getDimensionPixelSize(heightResId) / metrics.density
            : 0;
    }

    private float getSoftMenuBarHeight(DisplayMetrics metrics) {
        final float realHeight = getRealHeight(metrics);
        final Context ctx = getReactApplicationContext();
        final DisplayMetrics usableMetrics = ctx.getResources().getDisplayMetrics();

        mCurrentActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int usableHeight = usableMetrics.heightPixels;

        return Math.max(0, realHeight - usableHeight / metrics.density);
    }

    private float getRealHeight(DisplayMetrics metrics) {
        return metrics.heightPixels / metrics.density;
    }

    private float getRealWidth(DisplayMetrics metrics) {
        return metrics.widthPixels / metrics.density;
    }
}

