package com.meapps.abc2num.activities;
import android.support.v7.app.*;
import android.os.*;
import android.content.*;
import android.preference.*;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.putExtra("dark_mode", PreferenceManager.getDefaultSharedPreferences(SplashActivity.this).getBoolean("dark_mode", false));
        startActivity(intent);
        finish();
    }
    
}
