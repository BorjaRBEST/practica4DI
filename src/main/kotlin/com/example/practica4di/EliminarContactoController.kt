package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class EliminarContactoController {

    // Instancia del gestor de contactos
    private val gestorDeContactos = GestorDeContactos.getInstance()


    @FXML
    private lateinit var tfIDCorreoEliminar: TextField

    @FXML
    private lateinit var tfResultadoEliminarUsuario: TextField

    // Método que se ejecuta al hacer clic en el botón de volver
    @FXML
    private fun onVolverButtonClick(event: ActionEvent) {
        try {
            // Obtener el nodo fuente y cerrar la ventana
            val node = event.source as Node
            val stage = node.scene.window as Stage
            stage.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // Método que se ejecuta al hacer clic en el botón de eliminar
    @FXML
    private fun onEliminarButtonClick(event: ActionEvent) {
        // Obtener el ID de correo a eliminar
        val idCorreo = tfIDCorreoEliminar.text

        // Intentar eliminar el contacto y obtener el resultado
        val exito = gestorDeContactos.eliminarContacto(idCorreo)

        // Mostrar el resultado de la eliminación en el campo de texto correspondiente
        if (exito) {
            tfResultadoEliminarUsuario.text = "Contacto eliminado con éxito: $idCorreo"
        } else {
            tfResultadoEliminarUsuario.text = "No se encontró ningún contacto con el correo: $idCorreo"
        }
    }
}
