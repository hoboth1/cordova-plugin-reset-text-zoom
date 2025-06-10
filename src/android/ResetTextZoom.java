package com.example.resettextzoom;

import android.webkit.WebSettings;
import org.apache.cordova.*;
import org.apache.cordova.engine.SystemWebViewEngine;
import org.json.JSONArray;

public class ResetTextZoom extends CordovaPlugin {

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        cordova.getActivity().runOnUiThread(() -> {
            WebSettings settings = ((SystemWebViewEngine) webView.getEngine()).getView().getSettings();
            settings.setTextZoom(100);
        });
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        return false;
    }
}
