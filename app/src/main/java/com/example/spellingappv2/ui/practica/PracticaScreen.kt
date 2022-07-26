package com.example.spellingappv2.ui.practica

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spellingappv2.model.Palabra
import com.example.spellingappv2.ui.Palabra.WordViewModel
import com.example.spellingappv2.ui.theme.Yellow1

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PracticaScreen(
    navHostController : NavHostController,
    viewModelPalabra : WordViewModel = hiltViewModel()
) {
    val state = viewModelPalabra.state.value


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
        //TODO: Palabras llega vacio, pero en WordQuery siendo la misma linea se llena :)
        val palabras = viewModelPalabra.listado.collectAsState(initial = emptyList()).value
        var palabra = viewModelPalabra.GetPalabra(palabras = palabras)
        var index : Int = 0

        Row(modifier = Modifier
            .size(height = 80.dp, width=80.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                .data(palabra.imagenUrl)
                .build(),
                contentDescription = null
            )
        }
        
        Row(
            horizontalArrangement = Arrangement.End
        ){
            Button(onClick = {
                palabra = viewModelPalabra.GetPalabra(index, palabras)
                index += 1
            }) {
                Icon(imageVector = Icons.Default.ArrowLeft, contentDescription = "")
            }
        }
        
        Row(modifier = Modifier) {
            Text(text = palabra.descripcion)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = palabra.palabra)
        }
    }
}

