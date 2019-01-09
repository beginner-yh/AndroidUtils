package com.yh.utilslib;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.StringDef;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 手机制造商信息工具类
 * 1.获取设备的制造商
 * 2.打印设备制造商基本信息
 *
 * @author yh
 * @date 2018/12/15
 */
public class ManufacturerInfoUtils {

    private static final String TAG = "ManufacturerInfoUtils";

    /**
     * 华为手机
     */
    private static final String HUAWEI = "huawei";
    /**
     * VIVO手机
     */
    private static final String VIVO = "vivo";
    /**
     * 小米手机
     */
    private static final String XIAOMI = "xiaomi";
    /**
     * OPPO手机
     */
    private static final String OPPO = "oppo";
    /**
     * ZUK手机（联想）
     */
    private static final String ZUK = "zuk";
    /**
     * ZTE手机（中兴）
     */
    private static final String ZTE = "zte";
    /**
     * 魅族手机
     */
    private static final String MEIZU = "meizu";
    /**
     * 其他手机
     */
    private static final String OTHER = "other";

    @StringDef({HUAWEI, VIVO, XIAOMI, OPPO, ZUK, ZTE, MEIZU, OTHER})
    @Retention(RetentionPolicy.SOURCE)
    private @interface Manufacturer {

    }

    //根据Build.MANUFACTURER判断
    /**
     * 制造商为huawei的标识
     */
    private static final String MANUFACTURER_HUAWEI = "HUAWEI";
    /**
     * 制造商为XIAOMI的标识
     */
    private static final String MANUFACTURER_XIAOMI = "XIAOMI";
    /**
     * 制造商为VIVO的标识
     */
    private static final String MANUFACTURER_VIVO = "VIVO";
    /**
     * 制造商为OPPO的标识
     */
    private static final String MANUFACTURER_OPPO = "OPPO";
    /**
     * 制造商为魅族的标识
     */
    private static final String MANUFACTURER_MEIZU = "Meizu";
    /**
     * 制造商为ZUK的标识(联想)
     */
    private static final String MANUFACTURER_ZUK = "ZUK";
    /**
     * 制造商为ZTE的标识(中兴)
     */
    private static final String MANUFACTURER_ZTE = "ZTE";

    @Manufacturer
    public static String getCurrentDeviceManufacturer() {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer.equalsIgnoreCase(MANUFACTURER_HUAWEI)) {
            return HUAWEI;
        } else if (manufacturer.equalsIgnoreCase(MANUFACTURER_XIAOMI)) {
            return XIAOMI;
        } else if (manufacturer.equalsIgnoreCase(MANUFACTURER_VIVO)) {
            return VIVO;
        } else if (manufacturer.equalsIgnoreCase(MANUFACTURER_OPPO)) {
            return OPPO;
        } else if (manufacturer.equalsIgnoreCase(MANUFACTURER_MEIZU)) {
            return MEIZU;
        } else if (manufacturer.equalsIgnoreCase(MANUFACTURER_ZUK)) {
            return ZUK;
        } else if (manufacturer.equalsIgnoreCase(MANUFACTURER_ZTE)) {
            return ZTE;
        } else {
            return OTHER;
        }
    }


    @SuppressLint("WrongConstant")
    public static void printManufacturerInfo() {
        Log.i(TAG, "ManufacturerInfo: " + Build.MANUFACTURER);
        Log.i(TAG, "Device Manufacturer: " + getCurrentDeviceManufacturer());
    }

    /**
     * 判断是否为Vivo手机
     */
    public static boolean isVivo() {
        return VIVO.equals(getCurrentDeviceManufacturer());
    }

    /**
     * 判断是否为OPPO手机
     */
    public static boolean isOppo() {
        return OPPO.equalsIgnoreCase(getCurrentDeviceManufacturer());
    }

    /**
     * 判断是否为小米手机
     */
    public static boolean isXiaomi() {
        return XIAOMI.equalsIgnoreCase(getCurrentDeviceManufacturer());
    }

    /**
     * 判断是否为华为手机
     */
    public static boolean isHuawei() {
        return HUAWEI.equalsIgnoreCase(getCurrentDeviceManufacturer());
    }

}
