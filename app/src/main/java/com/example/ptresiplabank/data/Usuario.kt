package com.example.ptresiplabank.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var NombreCompleto: String,
    var RUT: String,
    var FechaNacimiento: LocalDate,
    var Email: String,
    var Teléfono: String,
    var Latitud: Long,
    var Longitud: Long,
    var ImgCedulaFrente: String,
    var ImgCedulaTrasera: String,
    var FechaCreacionSolicitud: LocalDate,
    var contrasena: String,
)