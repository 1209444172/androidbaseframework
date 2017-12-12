package com.app;


import com.commonutils.LogUtils;
import com.example.enyoshio.autoday.BuildConfig;

/**
 * APPLICATION
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化logger
        LogUtils.logi("AppApplication","appappliction  onCreate");
    }
}
