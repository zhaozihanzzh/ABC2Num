package com.meapps.abc2num;
import android.util.*;

public class LogUtils {
    private static String TAG = "com.meapps.abc2num";
    private static boolean isDebugging = BuildConfig.DEBUG;
    public static void d(String info){
        if(isDebugging){
            Log.d(TAG, info);
        }
    }
}
