package com.deniz.compose_cleanarchitecture.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoadingLayout() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(0, 0, 0, 200))
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
        )
    }
}

@Preview
@Composable
private fun LoadingLayoutPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LoadingLayout()
    }
}