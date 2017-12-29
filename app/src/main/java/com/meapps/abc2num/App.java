package com.meapps.abc2num;
import android.app.*;
import android.content.*;
import android.net.*;
import java.util.*;
import android.provider.*;
import android.support.v4.content.*;
import android.content.pm.*;
import android.support.v4.app.*;

public class App extends Application {
    private static List<Activity> mActivities = new ArrayList<>();
    public static void addActivity(Activity activity) {
        LogUtils.d(mActivities.add(activity) + " to Create activity " + activity);
    }
    public static List<Activity> getActivities() {
        return mActivities;
    }
    public static void removeActivity(Activity activity) {     
        LogUtils.d(mActivities.remove(activity) + "to Destroy activity " + activity);
    }
    public static void finishAll() {
        for (Activity a : mActivities) {
            if (!a.isFinishing()) {
                a.finish();
            }
        }
    }
    public static boolean getPermissionGranted(Activity activity, String name, int requestCode){
        LogUtils.d(activity.toString() + " requests "+ name);
        if(ContextCompat.checkSelfPermission(activity, name) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, new String[]{name}, requestCode);
            return false;
        }
        return true;
    }
    public static Intent getDetailPermission(String packageName){
        Intent detailPermission = new Intent();
        detailPermission.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        detailPermission.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        detailPermission.setData(Uri.fromParts("package", packageName, null));
        return detailPermission;
    }
}
