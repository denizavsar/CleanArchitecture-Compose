package com.deniz.compose_cleanarchitecture.repository

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor(
    context: Context
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_shared_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val ONBOARDING_ENABLED = "is_onboarding_enabled"
    }

    fun saveOnboardingStatus(isEnabled: Boolean) {
        sharedPreferences.edit().putBoolean(ONBOARDING_ENABLED, isEnabled).apply()
    }

    fun getOnboardingStatus(): Boolean {
        return sharedPreferences.getBoolean(ONBOARDING_ENABLED, true)
    }
}