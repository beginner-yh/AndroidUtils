package com.yh.utilslib;

import android.os.Environment;
import android.support.annotation.StringDef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 判断当前设备的系统UI及其对应版本
 *
 * @author yh
 * @date 2019/1/10 0010
 */
public class SystemUiUtils {

    /**
     * 原生系统UI
     */
    private static final String ANDROID_UI = "Android Ui";
    /**
     * Huawei Emotion UI
     */
    private static final String EMUI = "EMUI";


    @StringDef({ANDROID_UI, EMUI})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SystemUi {

    }

    @SystemUi
    public static String getSystemUi() {
        if (ManufacturerInfoUtils.isHuawei() && isEMUI()) {
            return EMUI;
        }
        return ANDROID_UI;
    }

    public static String getSytemUiVersion() {
        String deviceUi = getSystemUi();
        if (EMUI.equals(deviceUi)) {
            return getEMUIVersion();
        }
        return "";
    }


    private static final String KEY_EMUI_VERSION_CODE = "ro.build.version.emui";
    private static final String KEY_EMUI_API_LEVEL = "ro.build.hw_emui_api_level";
    private static final String KEY_EMUI_CONFIG_HW_SYS_VERSION = "ro.confg.hw_systemversion";

    /**
     * 判断是否为EMUI
     */
    private static boolean isEMUI() {
        return ManufacturerInfoUtils.isHuawei();
    }

    private static String getEMUIVersion() {
        return getSystemProperty(KEY_EMUI_VERSION_CODE);
    }

    private static Properties getBuildProp() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    private static String getSystemProperty(String key) {
        try {
            Class<?> clz = Class.forName("android.os.SystemProperties");
            Method get = clz.getMethod("get", String.class, String.class);
            return (String) get.invoke(clz, key, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
