package com.deniz.compose_cleanarchitecture.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deniz.compose_cleanarchitecture.ui.screens.app.login.LoginScreen
import com.deniz.compose_cleanarchitecture.ui.screens.app.register.RegisterScreen
import com.deniz.compose_cleanarchitecture.ui.screens.onboarding.OnboardingScreen

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Onboarding",
        modifier = Modifier
            .fillMaxSize()
    ) {
        composable("Onboarding") {
            OnboardingScreen(
                onBoardingCompleted = {
                    navController.navigate("App") {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable("App") {
            AppNavGraph(hostNavController = navController)
        }


        /*
        navigation(
            startDestination = "Login",
            route = "App"
        ) {
            composable("Login") {
                LoginScreen(
                    onRegisterClicked = {
                        navController.navigate("Register")
                    }
                )
            }
            composable("Register") {
                RegisterScreen()
            }
        }
         */
    }
}

@Composable
fun AppNavGraph(
    hostNavController: NavController
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login") {
        composable("Login") {
            LoginScreen(
                onRegisterClicked = {
                    navController.navigate("Register")
                }
            )
        }
        composable("Register") {
            RegisterScreen(onBack = {
                hostNavController.navigate("Onboarding") {
                    popUpTo(0) { inclusive = true }
                    launchSingleTop = true
                }
            })
        }
    }
}
