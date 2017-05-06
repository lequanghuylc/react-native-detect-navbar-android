package com.rndetectnavbarandroid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.WindowManager;
import android.view.KeyCharacterMap;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.Display;
import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;

/**
 * {@link NativeModule} that allows changing the appearance of the menu bar.
 */
public class RNDetectNavbarAndroidModule extends ReactContextBaseJavaModule { 

  ReactApplicationContext reactContext;

  public RNDetectNavbarAndroidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNDetectNavbarAndroid";
  }

  @ReactMethod
  public void hasSoftKeys(final Promise promise) {    
    promise.resolve(hasImmersive());
  }  

  private static boolean hasImmersive;
  private static boolean cached = false;

  @SuppressLint ("NewApi")
  private boolean hasImmersive() {

      if (!cached) {
          if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
              hasImmersive = false;
              cached = true;
              return false;
          }
          Display d = ((WindowManager) reactContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

          DisplayMetrics realDisplayMetrics = new DisplayMetrics();
          d.getRealMetrics(realDisplayMetrics);

          int realHeight = realDisplayMetrics.heightPixels;
          int realWidth = realDisplayMetrics.widthPixels;

          DisplayMetrics displayMetrics = new DisplayMetrics();
          d.getMetrics(displayMetrics);

          int displayHeight = displayMetrics.heightPixels;
          int displayWidth = displayMetrics.widthPixels;

          hasImmersive = (realWidth > displayWidth) || (realHeight > displayHeight);
          cached = true;
      }

      return hasImmersive;
  }
}
