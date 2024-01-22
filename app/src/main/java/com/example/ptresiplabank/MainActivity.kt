package com.example.ptresiplabank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import com.example.ptresiplabank.data.Usuario
import com.example.ptresiplabank.ui.UsuarioRegViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import java.time.LocalDate


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
AppUsuariosUi()
        }
    }
}


@Composable
fun AppUsuariosUi(
    viewModelus: UsuarioRegViewModel = viewModel(factory = UsuarioRegViewModel.Factory)

){
    //una ejecucion
LaunchedEffect(Unit){
    viewModelus.obtenerUsuarios()
}
   LazyColumn{
       items(viewModelus.usuarios.size) { index ->
           val usuario = viewModelus.usuarios[index]
           Text(usuario.Email)
       }
       item {
           Button(onClick = {
               viewModelus.insertarUsuario(
                   Usuario(
                       id = null,
                       NombreCompleto = "Nombre por defecto",
                       RUT = "RUT por defecto",
                       FechaNacimiento = LocalDate.now(),
                       Email = "correo@example.com",
                       Teléfono = "123456789",
                       Latitud = 0,
                       Longitud = 0,
                       ImgCedulaFrente = "ruta/cedula_frente.jpg",
                       ImgCedulaTrasera = "ruta/cedula_trasera.jpg",
                       FechaCreacionSolicitud = LocalDate.now(),
                       contrasena = "contrasena"
                   )
               )
           }) {
               Text(text = "Agregar")
           }


       }

   }

}
