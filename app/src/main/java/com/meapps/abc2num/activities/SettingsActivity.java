package com.meapps.abc2num.activities;
import android.preference.*;
import android.os.*;
import com.meapps.abc2num.*;
import android.support.design.widget.*;
import android.view.*;
import android.content.*;

public final class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);

        addPreferencesFromResource(R.xml.settings);
        ListPreference showBingImage = (ListPreference)findPreference("bing_image");
        showBingImage.setOnPreferenceChangeListener(new ListPreference.OnPreferenceChangeListener(){
                @Override
                public boolean onPreferenceChange(Preference p1, Object p2) {
                    Snackbar.make(getListView(), "设置成功，重启软件后生效。", Snackbar.LENGTH_SHORT).setAction("立即重启",
                        new View.OnClickListener(){
                            @Override
                            public void onClick(View p1) {
                                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                                App.finishAll();
                                startActivity(intent);
                            }
                        }).show();
                    return true;
                }
            });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.removeActivity(this);
    }
}
