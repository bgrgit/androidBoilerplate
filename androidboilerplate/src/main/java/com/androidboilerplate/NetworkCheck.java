package com.androidboilerplate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by bgnanaraj on 7/18/2017.
 */

public class NetworkCheck {
    private static Context mContext;
    private static NetworkCheck sInstance;

    private NetworkCheck() {

    }

    public static synchronized NetworkCheck getInstance(Context context) {
        mContext = context;
        if (sInstance == null) {
            sInstance = new NetworkCheck();
        }
        return sInstance;
    }

    public boolean isNetworkConnectionAvailable() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

}
