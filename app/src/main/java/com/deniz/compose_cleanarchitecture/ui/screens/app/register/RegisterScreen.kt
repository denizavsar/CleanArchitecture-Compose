package com.deniz.compose_cleanarchitecture.ui.screens.app.register

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Text(text = "Register")
    Button(onClick = { onBack.invoke() }) {
        Text(text = "Back")
    }
}