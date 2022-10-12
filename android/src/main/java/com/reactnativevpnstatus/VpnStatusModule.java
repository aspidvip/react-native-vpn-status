package com.reactnativevpnstatus;

import androidx.annotation.NonNull;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = VpnStatusModule.NAME)
public class VpnStatusModule extends ReactContextBaseJavaModule {
    public static final String NAME = "VpnStatus";
    private final ReactApplicationContext reactContext;


  public VpnStatusModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

  @ReactMethod
  public void detectVPN(Promise promise){
    ConnectivityManager cm = (ConnectivityManager) reactContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    Network[] networks = new Network[0];
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      networks = cm.getAllNetworks();
    }

    boolean isRunningVPN = false;
    for (Network value : networks) {
      NetworkCapabilities caps = null;
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        caps = cm.getNetworkCapabilities(value);
      }
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        if (caps != null && (caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN) || !caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN))) {
          isRunningVPN = true;
          break;
        }
      }
    }
    promise.resolve(isRunningVPN);
  }


    public static native int nativeMultiply(int a, int b);

}
