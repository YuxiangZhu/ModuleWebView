package com.xiangxue.webview;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.kingja.loadsir.core.LoadSir;
import com.xiangxue.base.BaseApplication;
import com.xiangxue.base.loadsir.CustomCallback;
import com.xiangxue.base.loadsir.EmptyCallback;
import com.xiangxue.base.loadsir.ErrorCallback;
import com.xiangxue.base.loadsir.LoadingCallback;
import com.xiangxue.base.loadsir.TimeoutCallback;

public class XiangxueWebViewApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();

//        List<IKit> kits = new ArrayList<>();
//        kits.add(new DemoKit());
        DoraemonKit.install(this);
    }
}
