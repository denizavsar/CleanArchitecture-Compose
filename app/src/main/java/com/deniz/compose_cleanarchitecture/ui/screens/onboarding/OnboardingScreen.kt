package com.deniz.compose_cleanarchitecture.ui.screens.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onBoardingCompleted: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 3 })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
    ) { page ->
        when (page) {
            0 -> OnboardingFirstPage()
            1 -> OnboardingSecondPage()
            2 -> OnboardingThirdPage(
                onDoneClicked = onBoardingCompleted
            )
        }
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(
        onBoardingCompleted = {}
    )
}

@Composable
fun OnboardingFirstPage(modifier: Modifier = Modifier) {
    Text("111111!")
}

@Composable
fun OnboardingSecondPage(modifier: Modifier = Modifier) {
    Text("22222!")
}

@Composable
fun OnboardingThirdPage(modifier: Modifier = Modifier, onDoneClicked: () -> Unit) {
    Text("33333!")
    Button(onClick = { onDoneClicked.invoke() }) {
        Text(text = "Done")
    }
}