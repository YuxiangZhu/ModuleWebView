package com.xiangxue.webview;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xiangxue.webview.databinding.ActivityWebviewBinding;
import com.xiangxue.webview.utils.Constants;

import static android.view.KeyEvent.KEYCODE_BACK;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebviewBinding mBinding;
    private WebViewFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        mBinding.title.setText(getIntent().getStringExtra(Constants.TITLE));
        mBinding.actionBar.setVisibility(getIntent().getBooleanExtra(Constants.IS_SHOW_ACTION_BAR, true) ? View.VISIBLE : View.GONE);
        mBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragment != null && fragment.getWebView().canGoBack()) {
                    fragment.getWebView().goBack();
                } else {
                    finish();
                }
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragment = WebViewFragment.newInstance(getIntent().getStringExtra(Constants.URL), true);
        transaction.replace(R.id.web_view_fragment, fragment).commit();
    }

    public void updateTitle(String title) {
        mBinding.title.setText(title);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && fragment != null && fragment.getWebView().canGoBack()) {
            fragment.getWebView().goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
