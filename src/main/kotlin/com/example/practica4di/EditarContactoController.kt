package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class EditarContactoController {

    private val gestorDeContactos = GestorDeContactos.getInstance()

    @FXML
    private lateinit var tfIDCorreo: TextField

    @FXML
    private lateinit var tfNombre: TextField

    @FXML
    private lateinit var tfApellidos: TextField

    @FXML
    private lateinit var tfTelefono: TextField

    @FXML
    private lateinit var tfIDCorreoNew: TextField

    @FXML
    private lateinit var tfResultado: TextField

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
        val telefono = try {
            tfTelefono.text.toInt()
        } catch (e: NumberFormatException) {
            0
        }
        val correo = tfIDCorreoNew.text

        val exito = gestorDeContactos.actualizarContacto(idCorreo, nombre, apellido, telefono, correo)

        if (exito) {
            tfResultado.text = "Cambios realizados con éxito en el usuario $idCorreo"
        } else {
            tfResultado.text = "Usuario no encontrado"
        }
    }
}
