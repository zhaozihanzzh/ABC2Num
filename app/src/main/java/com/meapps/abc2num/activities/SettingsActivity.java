package com.meapps.abc2num.activities;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.preference.*;
import android.support.annotation.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.view.*;
import com.meapps.abc2num.*;

public final class SettingsActivity extends PreferenceActivity {
    private int mThemeId = 0;
    private AppCompatDelegate mDelegate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		final AppCompatDelegate delegate = getDelegate();
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);
		if (delegate.applyDayNight() && mThemeId != 0) {
            // If DayNight has been applied, we need to re-apply the theme for
            // the changes to take effect. On API 23+, we should bypass
            // setTheme(), which will no-op if the theme ID is identical to the
            // current theme ID.
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), mThemeId, false);
            } else {
                setTheme(mThemeId);
            }
        }
		// https://github.com/aosp-mirror/platform_frameworks_support/blob/master/v7/appcompat/src/main/java/android/support/v7/app/AppCompatActivity.java

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
                public boolean onPreferenceChange(Preference p, Object value) {
                    AppCompatDelegate.setDefaultNightMode(darkMode.isChecked() ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);
                    rebootToWork();
                    return true;
                }
            });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
        App.removeActivity(this);
    }
    private void rebootToWork() {
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
	@Override
    public void setTheme(final int resid) {
        super.setTheme(resid);
        // Keep hold of the theme id so that we can re-set it later if needed
        mThemeId = resid;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
    }
	
	private AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }
	@Override
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getDelegate().setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().addContentView(view, params);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        getDelegate().setTitle(title);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDelegate().onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

}
