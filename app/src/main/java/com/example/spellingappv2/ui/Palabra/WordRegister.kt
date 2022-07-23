package com.example.spellingappv2.ui.Palabra

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.spellingappv2.ui.theme.Blue1
import com.example.spellingappv2.util.Screen

@Composable
fun WordRegister(
    navHostController: NavHostController,
    viewModel: WordViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    var validar = LocalContext.current
    val focusRequesterWord = FocusRequester()
    val focusRequesterDescription = FocusRequester()


    var error by remember {
        mutableStateOf(false)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "WORDS REGISTER",
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold
                    )

                },
                backgroundColor = Blue1,
                navigationIcon = {
                    IconButton(onClick = {
                        navHostController.navigate(Screen.WordQuery.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "CONSULTA",
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,

        ) {
        Column(
            Modifier
                .padding(it)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = viewModel.word,
                label = {
                    Text(
                        text = "Word",
                        fontStyle = FontStyle.Italic
                    )
                },
                onValueChange = {
                    viewModel.word = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterWord),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Book,
                        contentDescription = null
                    )
                }
            )

            val assistiveElementText = if (error)
                "Error: Obligatorio" else "*Obligatorio"
            val assistiveElementColor = if (error) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors
                    .onSurface
                    .copy(alpha = ContentAlpha.medium)
            }

            Text(
                text = assistiveElementText,
                color = assistiveElementColor,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )

            OutlinedTextField(
                value = viewModel.description,
                label = {
                    Text(
                        text = "Description",
                        fontStyle = FontStyle.Italic
                    )
                },
                onValueChange = {
                    viewModel.description = it
                    error = false
                },
                isError = error,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterDescription),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null
                    )
                }
            )

            val Text = if (error)
                "Error: Obligatorio" else "*Obligatorio"
            val Color = if (error) {
                MaterialTheme
                    .colors
                    .error
            } else {
                MaterialTheme
                    .colors
                    .onSurface
                    .copy(alpha = ContentAlpha.medium)
            }

            Text(
                text = Text,
                color = Color,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )

            OutlinedTextField(
                value = viewModel.imageUrl,
                label = {
                    Text(
                        text = "Image Url",
                        fontStyle = FontStyle.Italic
                    )
                },
                onValueChange = {
                    viewModel.imageUrl = it
                },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = null
                    )
                },
            )

            Spacer(
                modifier = Modifier.width(20.dp)
            )
            Button(
                onClick = {
                    if (viewModel.word.isNullOrEmpty()) {
                        error = viewModel.word.isBlank()
                        Toast.makeText(
                            validar,
                            "The word field is empty!",
                            Toast.LENGTH_LONG
                        ).show()
                        focusRequesterWord.requestFocus()

                    } else if (viewModel.description.isNullOrEmpty()) {
                        error = viewModel.description.isBlank()
                        Toast.makeText(
                            validar,
                            "The description field is empty!",
                            Toast.LENGTH_LONG
                        ).show()
                        focusRequesterDescription.requestFocus()

                    } else {

                        viewModel.Guardar()
                        navHostController.navigate("NavegarConsulta")
                        Toast.makeText(validar, "Has been saved successfully!", Toast.LENGTH_LONG)
                            .show()
                        viewModel.word = ""
                        viewModel.description = ""
                        viewModel.imageUrl = ""
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                shape = CutCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Blue1,
                    contentColor = MaterialTheme.colors.onPrimary,
                ),

                ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Text("  SAVE")
            }
        }
    }
}