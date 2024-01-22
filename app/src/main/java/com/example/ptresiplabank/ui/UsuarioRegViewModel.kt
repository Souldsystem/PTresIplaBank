package com.example.ptresiplabank.ui

import android.text.Spannable.Factory
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ptresiplabank.data.UsuarioDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ptresiplabank.Aplicacion
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import com.example.ptresiplabank.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UsuarioRegViewModel(private val usuarioDao:UsuarioDao):ViewModel() {

    var usuarios by mutableStateOf<List<Usuario>>(emptyList())

    fun insertarUsuario(usuario:Usuario){
    viewModelScope.launch(Dispatchers.IO) {
    usuarioDao.insertar(usuario)
    obtenerUsuarios()
    }
    }


    fun obtenerUsuarios(): List<Usuario>{
    viewModelScope.launch(Dispatchers.IO) {
        usuarios = usuarioDao.obtenerTodos()
    }

    return usuarios
}

    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {

                val saveStateHandle = createSavedStateHandle()
                val aplication = (this[APPLICATION_KEY] as Aplicacion)
                UsuarioRegViewModel(aplication.userdao)
            }



        }

    }

}