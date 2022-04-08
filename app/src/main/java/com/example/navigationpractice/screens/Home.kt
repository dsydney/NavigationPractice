package com.example.navigationpractice.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navigationpractice.NavRoutes

@Composable
fun Home(navController: NavHostController) {

    var userName by remember { mutableStateOf("")}
    val onUsernameChange = {text: String ->
        userName = text
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Home Screen", style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.size(30.dp))

            CustomTextField(
                title = "Enter your name",
                textState = userName,
                onTextChange = onUsernameChange
            )

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick = { navController.navigate(NavRoutes.Welcome.route + "/$userName") }) {
                Text(text = "Register")
            }
        }
    }
}

@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = textState,
        onValueChange = {onTextChange(it) },
        singleLine = true,
        label = { Text(title) },
        modifier = Modifier
            .padding(10.dp),
        textStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    )
}