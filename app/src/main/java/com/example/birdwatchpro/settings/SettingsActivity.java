package com.example.birdwatchpro.settings;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean isUseMetric() {
        boolean useMetric2 = false;
        return useMetric2;
    }

    public int getMaxDistance() {
        int maxDistance2 = 0;
        return maxDistance2;
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }

    // Create a SharedPreferences object
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

    // Use SharedPreferences.Editor to make changes
    SharedPreferences.Editor editor = preferences.edit();

    {
        // Save the user's preferences
        boolean useMetric = true; // Default value
        int maxDistance = 10;    // Default value

        editor.putBoolean("useMetric", true);
        editor.putInt("maxDistance", 10);

        // Apply the changes
        editor.apply();
    }

    // Retrieve the SharedPreferences object
    SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
    {

        // Retrieve the values (provide default values as a fallback)
        boolean useMetric1 = preferences.getBoolean("useMetric", true); // Default value: true
        int maxDistance1 = preferences.getInt("maxDistance", 10);      // Default value: 10

    }

}