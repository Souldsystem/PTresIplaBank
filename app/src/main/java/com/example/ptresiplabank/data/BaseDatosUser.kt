package com.example.ptresiplabank.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Usuario::class], version = 1)
@TypeConverters(LocalDateConverter::class)

abstract class BaseDatosUser : RoomDatabase() {
    abstract  fun UsuarioDao():UsuarioDao
}