package com.xiangxue.webview;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.auto.service.AutoService;
import com.xiangxue.base.BaseApplication;
import com.xiangxue.webview.command.Command;

import java.util.Map;

@AutoService({Command.class})
public class CommandShowToast implements Command {
    private static final String TAG = "CommandShowToast";
    @Override
    public String name() {
        return "showToast";
    }

    @Override
    public void execute(final Map parameters, ICallbackFromMainprocessToWebViewProcessInterface callback) {
        Log.e(TAG, "execute: " + Thread.currentThread().getName());
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseApplication.sApplication, String.valueOf(parameters.get("message")), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
