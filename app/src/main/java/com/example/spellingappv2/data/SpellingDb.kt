package com.example.spellingappv2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spellingappv2.data.dao.PalabraDao
import com.example.spellingappv2.data.dao.PracticaDao
import com.example.spellingappv2.data.dao.UsuarioDao
import com.example.spellingappv2.model.Palabra
import com.example.spellingappv2.model.Practica
import com.example.spellingappv2.model.Usuario

@Database(
    entities = [Usuario::class, Palabra::class, Practica::class],
    exportSchema = false,
    version = 1
)

abstract class SpellingDb: RoomDatabase() {
    abstract val usuarioDao: UsuarioDao
    abstract val palabraDao : PalabraDao
    abstract val practicaDao : PracticaDao
}