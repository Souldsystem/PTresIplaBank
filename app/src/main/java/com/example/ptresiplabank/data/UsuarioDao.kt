package com.example.ptresiplabank.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
    interface UsuarioDao {


        @Query("SELECT * FROM Usuario ORDER BY FechaCreacionSolicitud DESC")
        suspend fun obtenerTodos(): List<Usuario>

        @Query("SELECT * FROM Usuario WHERE id = :id")
        suspend fun obtenerPorId(id: Long): Usuario?

        @Insert
        suspend fun insertar(usuario: Usuario)

        @Update
        suspend fun modificar(usuario: Usuario)

        @Delete
        suspend fun eliminar(usuario: Usuario)
    }
