package com.commonutils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.Random;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by enyoshio on 2017/12/4.
 */

public class ImeiUtils {
    private static String TAG = "ImeiUtils";
    public static String IMEI = "";
    public static String getImei(Activity activity) {
        if (!IMEI.isEmpty()) {
            LogUtils.logi(TAG, "直接获取 IMEI", IMEI);
            return IMEI;
        }
        return getImei((Context) activity);
    }

    public static String getImei(Context context) {
        if (!IMEI.isEmpty()) {
            LogUtils.logi(TAG, "直接获取 IMEI", IMEI);
            return IMEI;
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                IMEI = Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                LogUtils.logi(TAG, "Build.VERSION_CODES.M 23 IMEI", IMEI);
            } else {
                TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
                IMEI = TelephonyMgr.getDeviceId();
                if (IMEI.isEmpty()) {
                    return "";
                }
                LogUtils.logi(TAG, "6.0及以下 IMEI", IMEI);
            }
            if (IMEI.isEmpty()) {
                IMEI = new Random(Long.MAX_VALUE).nextInt() + "random";
            }
        } catch (Exception e) {
            LogUtils.logi(TAG, "setImei e", e.getMessage());
        }
        return IMEI;
    }
}
