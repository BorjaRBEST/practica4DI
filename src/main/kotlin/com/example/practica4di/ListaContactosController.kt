package com.example.practica4di


import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class ListaContactosController {

    private val gestorDeContactos = GestorDeContactos.getInstance()

    @FXML
    lateinit var tfMostrarLista: TextField

    @FXML
    lateinit var buttonVolver: Button

    @FXML
    lateinit var buttonListarUsuarios: Button

    @FXML
    fun onVolverButtonClick(event: ActionEvent) {
        try {
            val node = event.source as Node
            val stage = node.scene.window as Stage
            stage.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @FXML
    fun onListarUsuariosButtonClick(event: ActionEvent) {
        val listaDeContactos = gestorDeContactos.getListaDeContactos()

        if (listaDeContactos.isEmpty()) {
            tfMostrarLista.text = "No hay contactos en la lista."
        } else {
            val textoFormateado = StringBuilder()

            for (contacto in listaDeContactos) {
                val nombreCompleto = "${contacto.nombre} ${contacto.apellido}"
                val telefono = contacto.telefono
                val correo = contacto.correo

                val formato = "Nombre: $nombreCompleto, Teléfono: $telefono, Correo: $correo\n"
                textoFormateado.append(formato)
            }

            tfMostrarLista.text = textoFormateado.toString()
        }
    }

}
