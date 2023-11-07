package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class EliminarContactoController {

    private val gestorDeContactos = GestorDeContactos.getInstance()

    @FXML
    private lateinit var tfIDCorreoEliminar: TextField

    @FXML
    private lateinit var tfResultadoEliminarUsuario: TextField

    @FXML
    private fun onVolverButtonClick(event: ActionEvent) {
        try {
            val node = event.source as Node
            val stage = node.scene.window as Stage
            stage.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @FXML
    private fun onEliminarButtonClick(event: ActionEvent) {
        val idCorreo = tfIDCorreoEliminar.text
        val exito = gestorDeContactos.eliminarContacto(idCorreo)

        if (exito) {
            tfResultadoEliminarUsuario.text = "Contacto eliminado con éxito: $idCorreo"
        } else {
            tfResultadoEliminarUsuario.text = "No se encontró ningún contacto con el correo: $idCorreo"
        }
    }
}
