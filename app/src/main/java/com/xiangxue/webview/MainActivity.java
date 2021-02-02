package com.xiangxue.webview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xiangxue.base.autoservice.XiangxueServiceLoader;
import com.xiangxue.common.autoservice.IWebViewService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.open_webviewactivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IWebViewService webviewService = XiangxueServiceLoader.load(IWebViewService.class);
                if(webviewService != null) {
//                    webviewService.startDemoHtml(MainActivity.this);
//                    webviewService.clearCache(MainActivity.this);
                    webviewService.startWebViewActivity(MainActivity.this, "http://www.baidu.com", "Title", true);
//                    webviewService.getWebViewFragment("http://www.baidu.com/",true);
                }
            }
        });
    }
}