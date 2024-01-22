package com.example.ptresiplabank.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity
data class Solicitud(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var iduser: String,
    var FechaCreacionSolicitud: LocalDate
)