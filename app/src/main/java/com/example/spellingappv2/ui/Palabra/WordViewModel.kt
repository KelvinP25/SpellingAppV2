package com.example.spellingappv2.ui.Palabra

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spellingappv2.data.repositorios.PalabraRepository
import com.example.spellingappv2.model.Palabra
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    val palabraRepository: PalabraRepository
): ViewModel() {
    var word by mutableStateOf("")
    var description by mutableStateOf("")
    var imageUrl by mutableStateOf("")

    var listado = palabraRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            palabraRepository.insertar(
                Palabra(
                    palabra = word,
                    descripcion = description,
                    imagenUrl = imageUrl
                )
            )
        }
    }
}