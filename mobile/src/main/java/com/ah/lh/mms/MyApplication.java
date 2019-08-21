package com.ah.lh.mms;

import android.app.Application;

import com.xuexiang.xui.XUI;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initUI();
    }
    /**
     * 初始化XUI 框架
     */
    private void initUI() {
        XUI.init(this);
        XUI.debug(BuildConfig.DEBUG);
//        //设置默认字体为华文行楷
//        XUI.getInstance().initFontStyle("fonts/hwxk.ttf");
    }
}
