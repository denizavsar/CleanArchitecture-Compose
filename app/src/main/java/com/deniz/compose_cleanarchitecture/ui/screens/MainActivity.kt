package com.deniz.compose_cleanarchitecture.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.deniz.compose_cleanarchitecture.navigation.MainNavGraph
import com.deniz.compose_cleanarchitecture.ui.custom.LoadingLayout
import com.deniz.compose_cleanarchitecture.ui.states.MainActivityState
import com.deniz.compose_cleanarchitecture.ui.theme.ApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val mainActivityViewModel: MainActivityViewModel = hiltViewModel()
            val isLoading by mainActivityViewModel.isLoading.collectAsStateWithLifecycle()

            val state = MainActivityState(
                isLoading = isLoading
            )

            ApplicationTheme {
                ApplicationScreen(state)
            }
        }
    }
}

@Composable
fun ApplicationScreen(mainActivityState: MainActivityState = MainActivityState()) {
    val isLoading = mainActivityState.isLoading

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) { innerPadding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.Cyan)
        ) {
            MainNavGraph()
        }

        if (isLoading) {
            LoadingLayout()
        }
    }
}

@Preview
@Composable
private fun ApplicationScreenPreview() {
    val state = MainActivityState(
        isLoading = false
    )
    ApplicationTheme {
        ApplicationScreen(state)
    }
}