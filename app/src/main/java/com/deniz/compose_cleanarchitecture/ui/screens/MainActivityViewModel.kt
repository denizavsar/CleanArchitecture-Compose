package com.deniz.compose_cleanarchitecture.ui.screens

import androidx.lifecycle.ViewModel
import com.deniz.compose_cleanarchitecture.repository.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val sharedPrefRepo: SharedPreferencesRepository
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun setIsLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }
}