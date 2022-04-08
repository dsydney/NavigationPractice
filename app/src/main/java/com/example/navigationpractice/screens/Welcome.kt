package com.example.navigationpractice.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navigationpractice.NavRoutes


@Composable
fun Welcome(navController: NavHostController, userName: String?) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome, $userName", style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick = {
                navController.navigate(NavRoutes.Profile.route) {
                    popUpTo(NavRoutes.Home.route) //When you navigate, you create a stack of destinations,
                    // like a pancake stack. Here, we are 'popping', or removing, all the pancakes up to
                    // home, in other words, we are removing welcome from the backstack so the back button
                    // goes back to home, rather than back to the previous screen, welcome.
                }
            }) {
                Text(text = "Set up your Profile")
            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back")
            }
        }
    }
}