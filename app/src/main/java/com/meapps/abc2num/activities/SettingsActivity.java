package com.meapps.abc2num.activities;
import android.preference.*;
import android.os.*;
import com.meapps.abc2num.*;
import android.support.design.widget.*;
import android.view.*;
import android.content.*;
import android.support.v7.app.*;

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
                    rebootToWork();
                    return true;
                }
            });
            final CheckBoxPreference darkMode = (CheckBoxPreference) findPreference("dark_mode");
            darkMode.setOnPreferenceChangeListener(new CheckBoxPreference.OnPreferenceChangeListener(){
                @Override
                public boolean onPreferenceChange(Preference p, Object value){
                    AppCompatDelegate.setDefaultNightMode(darkMode.isChecked() ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);
                    rebootToWork();
                    return true;
                }
            });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.removeActivity(this);
    }
    private void rebootToWork(){
        Snackbar.make(getListView(), "设置成功，重启软件后生效。", Snackbar.LENGTH_SHORT)
                .setAction("立即重启", new View.OnClickListener(){
                @Override
                public void onClick(View p1) {
                    Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                    App.finishAll();
                    startActivity(intent);
                }
        }).show();
    }
}
