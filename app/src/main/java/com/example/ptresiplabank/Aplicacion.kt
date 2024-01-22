package com.example.ptresiplabank

import android.app.Application
import androidx.room.Room
import com.example.ptresiplabank.data.BaseDatosUser

class Aplicacion :Application() {
val db by lazy { Room.databaseBuilder(context = this,BaseDatosUser::class.java,name="usuarios.db").build() }
val userdao by lazy { db.UsuarioDao() }
    //val solicitudDao by lazy { db.solicitudDao }
}