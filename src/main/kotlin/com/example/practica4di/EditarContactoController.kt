package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class EditarContactoController {

    lateinit var gestorDeContactos: GestorDeContactos // Asegúrate de que esta línea esté presente

    @FXML
    private lateinit var tfIDCorreo: TextField

    @FXML
    private lateinit var tfNombre: TextField

    @FXML
    private lateinit var tfApellidos: TextField

    @FXML
    private lateinit var tfTelefono: TextField

    @FXML
    private lateinit var tfCorreo: TextField

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
    private fun onRegistrarButtonClick(event: ActionEvent) {
        val idCorreo = tfIDCorreo.text
        val nombre = tfNombre.text
        val apellido = tfApellidos.text
        val telefono = tfTelefono.text.toInt() // Asegúrate de que el teléfono es un entero
        val correo = tfCorreo.text

        // Lógica para actualizar el contacto con la ID de correo proporcionada
        gestorDeContactos.actualizarContacto(idCorreo, nombre, apellido, telefono, correo) // Corregido aquí
    }
}
