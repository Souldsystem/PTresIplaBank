package com.example.ptresiplabank.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Solicitud::class], version = 1)
@TypeConverters(LocalDateConverter::class)

abstract class BaseDatosSolicitud : RoomDatabase() {
    abstract  fun SolicitudDao():SolicitudDao
}