package com.example.mapandmsg;

import android.app.Application;
import android.content.Context;

//import androidx.multidex.MultiDex;

public class MyApplication extends Application {
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        //解决4.x运行崩溃的问题
//        MultiDex.install(this);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        initLibs();
    }
    /**
     * 初始化基础库
     */
    private void initLibs() {


//        XBasicLibInit.init(this);
//
//        XUpdateInit.init(this);
//
//        //运营统计数据
//        UMengInit.init(this);
//        //ANR监控
//        ANRWatchDogInit.init();
//
//        //cleanCloud
//        LeanCloudInit.init(this);
    }
    /**
     * @return 当前app是否是调试开发模式
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}
