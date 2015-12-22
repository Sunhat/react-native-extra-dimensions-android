package ca.jaysoo.extradimensions;

import java.lang.Math;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.app.Activity;

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
        Map<String, Object> constants =  new HashMap<>();

        constants.put("STATUS_BAR_HEIGHT", getStatusBarHeight());
        constants.put("SOFT_MENU_BAR_HEIGHT", getSoftMenuBarHeight());

        return constants;
    }

    private float getStatusBarHeight() {
        Context ctx = getReactApplicationContext();
        DisplayMetrics metrics = ctx.getResources().getDisplayMetrics();

        int heightResId = ctx.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return
          heightResId > 0
            ? ctx.getResources().getDimensionPixelSize(heightResId) / metrics.density
            : 0;
    }

    private float getSoftMenuBarHeight() {
        Context ctx = getReactApplicationContext();
        DisplayMetrics metrics = ctx.getResources().getDisplayMetrics();

        mCurrentActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;

        mCurrentActivity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        int realHeight = metrics.heightPixels;

        return Math.max(0, realHeight - usableHeight) / metrics.density;
    }
}

