package com.example.spellingappv2.ui.practica

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.spellingappv2.ui.theme.Blue1
import com.example.spellingappv2.ui.theme.Yellow1

@Composable
fun PracticaScreen(
    navHostController : NavHostController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                contentColor = contentColorFor(backgroundColor = Yellow1)
            ) {
                Icon(imageVector = Icons.Default.CheckCircle,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    ) {
        
    }
}