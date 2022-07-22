package com.example.spellingappv2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Practicas")
data class Practica (
    @PrimaryKey(autoGenerate = true)
    val practicaId : Int = 0,/*
    val fecha : Date = Calendar.getInstance().getTime()*/
    val usuarioId : Int = 0,
    val fraseId : Int = 0,
    val vecesPracticado : Int = 0
)