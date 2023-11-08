package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class EditarContactoController {

    // Instancia del gestor de contactos
    private val gestorDeContactos = GestorDeContactos.getInstance()

    // Declaraciones de campos de texto
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

    // Método que se ejecuta al hacer clic en el botón de registrar
    @FXML
    private fun onRegistrarButtonClick(event: ActionEvent) {
        // Obtener los valores de los campos de texto
        val idCorreo = tfIDCorreo.text
        val nombre = tfNombre.text
        val apellido = tfApellidos.text
        val telefono = try {
            tfTelefono.text.toInt() // Intentar convertir a entero
        } catch (e: NumberFormatException) {
            0 // Si hay un error, establecer en 0
        }
        val correo = tfIDCorreoNew.text

        // Intentar actualizar el contacto y obtener el resultado
        val exito = gestorDeContactos.actualizarContacto(idCorreo, nombre, apellido, telefono, correo)

        // Mostrar el resultado en el campo de texto de resultado
        if (exito) {
            tfResultado.text = "Cambios realizados con éxito en el usuario $idCorreo"
        } else {
            tfResultado.text = "Usuario no encontrado"
        }
    }
}
