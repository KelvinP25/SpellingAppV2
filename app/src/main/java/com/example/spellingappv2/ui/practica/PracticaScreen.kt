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
import com.example.spellingappv2.util.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PracticaScreen(
    navHostController: NavHostController,
    viewModel: WordViewModel = hiltViewModel(),
    palabraId : Int? = 0
) {
    var palabra = viewModel.GetPalabra(palabraId?:0)

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
        Column(){
            /*val lis = viewModel.listado.collectAsState(initial = emptyList()).value

            var palabra = viewModel.GetPalabra(palabras = lis)

            var index : Int = 0*/
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
                horizontalArrangement = Arrangement.Start
            ){
                Button(onClick =
                {
                    navHostController.navigate(Screen.PracticaScreen.route + "/${palabra.palabraId + 1}")
                }
                    //navHostController.navigate(Screen.PracticaScreen.route)
                    //palabra = viewModel.GetPalabra(p)
                    /*index += 1*/
                ) {
                    Icon(imageVector = Icons.Default.ArrowLeft, contentDescription = "")
                }
            }

            Row(modifier = Modifier) {
                Text(text = palabra.descripcion)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = palabra.palabra)
            }

        }
        //TODO: Palabras llega vacio, pero en WordQuery siendo la misma linea se llena :)



    }
}

