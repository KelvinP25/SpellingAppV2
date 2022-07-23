package com.example.spellingappv2.ui.Palabra

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.spellingappv2.model.Palabra
import com.example.spellingappv2.ui.theme.Blue1
import com.example.spellingappv2.util.Screen

@Composable
fun WordQuery(
    navHostController: NavHostController,
    viewModel: WordViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WORDS",
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold
                    )
                },
                backgroundColor = Blue1,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navHostController.navigate(Screen.WordRegister.route)},
                contentColor = contentColorFor(backgroundColor = Blue1)
            )
            {
                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint =  Color.Black)
            }
        },
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        ) {

            val lis = viewModel.listado.collectAsState(initial = emptyList()).value
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lis) { words ->
                    RowP(words)
                }
            }
        }
    }
}

@Composable
fun RowP(palabra: Palabra) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Word: ${palabra.palabra}")
        Text(text = "Description: ${palabra.descripcion}")
        Text(text = "Image Url: ${palabra.imagenUrl}")

    }
}