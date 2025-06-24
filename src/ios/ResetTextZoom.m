#import <Cordova/CDV.h>
#import <WebKit/WebKit.h>

@interface ResetTextZoom : CDVPlugin
@end

@implementation ResetTextZoom

- (void)pluginInitialize {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIView *webView = self.webView;
        WKWebView *wkWebView = nil;

        if ([webView isKindOfClass:[WKWebView class]]) {
            wkWebView = (WKWebView *)webView;
        } else {
            for (UIView *view in webView.subviews) {
                if ([view isKindOfClass:[WKWebView class]]) {
                    wkWebView = (WKWebView *)view;
                    break;
                }
            }
        }

        if (wkWebView) {
            [wkWebView evaluateJavaScript:
              @"document.getElementsByTagName('body')[0].style.webkitTextSizeAdjust='100%';"
              completionHandler:nil];
        }
    });
}

@end
