package com.example.resettextzoom;

import android.webkit.WebSettings;
import android.webkit.WebView;
import org.apache.cordova.*;
import org.apache.cordova.engine.SystemWebViewEngine;
import org.json.JSONArray;

public class ResetTextZoom extends CordovaPlugin {

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        cordova.getActivity().runOnUiThread(() -> {
            // ЗМІНІТЬ ЦЕЙ РЯДОК:
            WebSettings settings = ((android.webkit.WebView) ((SystemWebViewEngine) webView.getEngine()).getView()).getSettings();
            settings.setTextZoom(100);
        });
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        return false;
    }
}
