package com.meapps.abc2num;
import android.app.*;
import java.util.*;
import android.util.*;

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
}
