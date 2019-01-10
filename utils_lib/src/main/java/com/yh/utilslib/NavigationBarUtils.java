package com.yh.utilslib;

import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;

import static com.yh.utilslib.ScreenInfoUtils.getOrientation;

/**
 * 判断是否有NavigationBar显示
 *
 * @author yh
 * @date 2019/1/9
 */
public class NavigationBarUtils {

    /**
     * 判断NavigationBar是否显示
     */
    public static boolean hasNavigationBarCompat(Context context) {
        if (ManufacturerInfoUtils.isVivo()) {
            return hasNavigationBarCompatVivo(context);
        } else if (ManufacturerInfoUtils.isXiaomi()) {
            return hasNavigationBarCompatXiaomi(context);
        } else {
            return hasNavigationBarCommon(context);
        }
    }


    /**
     * 判断NavigationBar是否显示（一般方法）
     */
    private static boolean hasNavigationBarCommon(Context context) {
        if (getOrientation(context) == Configuration.ORIENTATION_PORTRAIT) {
            //portrait
            return (ScreenInfoUtils.getRealHeight(context) - ScreenInfoUtils.getScreenHeight(context)) > 0;
        } else {
            //landscape
            return (ScreenInfoUtils.getRealWidth(context) - ScreenInfoUtils.getScreenWidth(context)) > 0;
        }
    }

    private static final String NAVIGATION_GESTURE = "navigation_gesture_on";
    private static final int NAVIGATION_GESTURE_OFF = 0;

    /**
     * 判断NavigationBar是否显示(适配Vivo手机)
     */
    private static boolean hasNavigationBarCompatVivo(Context context) {
        int val = Settings.Secure.getInt(context.getContentResolver(), NAVIGATION_GESTURE, NAVIGATION_GESTURE_OFF);
        return val == NAVIGATION_GESTURE_OFF;
    }

    /**
     * 判断NavigationBar是否显示(适配Xiaomi手机)
     * 全面屏
     */
    private static boolean hasNavigationBarCompatXiaomi(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0;
    }

}
