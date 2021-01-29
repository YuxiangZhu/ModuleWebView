package com.xiangxue.webview.webviewprocess.webchromeclient;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.xiangxue.webview.WebViewCallBack;

public class XiangxueWebChromeClient extends WebChromeClient {
    private WebViewCallBack mWebViewCallBack;
    private static final String TAG = "XiangxueWebChromeClient";

    public XiangxueWebChromeClient(WebViewCallBack webViewCallBack) {
        this.mWebViewCallBack = webViewCallBack;
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        if (mWebViewCallBack != null) {
            mWebViewCallBack.updateTitle(title);
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }

    /**
     * 具体进度的进度条回调在此
     *
     * @param view
     * @param newProgress
     */
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        Log.e(TAG, "onProgressChanged: " + newProgress);
    }

    /**
     * Report a JavaScript console message to the host application. The ChromeClient
     * should override this to process the log message as they see fit.
     *
     * @param consoleMessage Object containing details of the console message.
     * @return {@code true} if the message is handled by the client.
     * <p>
     * js里面
     * console.log("callAppToast.");
     */
    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        // Call the old version of this function for backwards compatability.
        Log.d(TAG, consoleMessage.message());
        return super.onConsoleMessage(consoleMessage);
    }

}
