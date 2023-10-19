package com.example.birdwatchpro.settings



import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBar
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun isUseMetric(): Boolean {
        return false
    }

    fun getMaxDistance(): Int {
        return 0
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }

    // Create a SharedPreferences object
    private val preferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    // Use SharedPreferences.Editor to make changes
    private val editor: SharedPreferences.Editor by lazy {
        preferences.edit()
    }

    init {
        // Save the user's preferences
        val useMetric = true // Default value
        val maxDistance = 10 // Default value

        editor.putBoolean("useMetric", useMetric)
        editor.putInt("maxDistance", maxDistance)

        // Apply the changes
        editor.apply()
    }

    // Retrieve the SharedPreferences object
    private val preferences1: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    init {
        // Retrieve the values (provide default values as a fallback)
        val useMetric1 = preferences1.getBoolean("useMetric", true) // Default value: true
        val maxDistance1 = preferences1.getInt("maxDistance", 10)    // Default value: 10
    }
}