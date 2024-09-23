package com.deniz.compose_cleanarchitecture.ui.screens.app.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onRegisterClicked: () -> Unit
) {
    Text(text = "Login")
    Button(onClick = { onRegisterClicked.invoke() }) {
        Text(text = "Go register")
    }
}