package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class AgregarContactoController {

    // Instancia del gestor de contactos
    private val gestorDeContactos = GestorDeContactos.getInstance()

    // Declaraciones de campos de texto
    @FXML
    private lateinit var tfNombre: TextField

    @FXML
    private lateinit var tfApellidos: TextField

    @FXML
    private lateinit var tfTelefono: TextField

    @FXML
    private lateinit var tfCorreo: TextField

    @FXML
    private lateinit var tfResultado: TextField

    // Método que se ejecuta al hacer clic en el botón de registrar
    @FXML
    fun onRegistrarButtonClick() {
        // Obtener los valores de los campos de texto
        val nombre = tfNombre.text
        val apellidos = tfApellidos.text
        val telefono = try {
            tfTelefono.text.toInt() // Intentar convertir a entero
        } catch (e: NumberFormatException) {
            0 // Si hay un error, establecer en 0
        }
        val correo = tfCorreo.text

        // Crear un objeto de contacto
        val contacto = Contacto(nombre, apellidos, telefono, correo)

        // Agregar el contacto al gestor de contactos
        gestorDeContactos.agregarContacto(contacto)

        // Mostrar un mensaje de éxito en el campo de texto de resultado
        tfResultado.text = "Contacto registrado correctamente: $nombre $apellidos"
    }

    // Método que se ejecuta al hacer clic en el botón de volver
    @FXML
    fun onVolverButtonClick(event: ActionEvent) {
        try {
            // Obtener el nodo fuente y cerrar la ventana
            val node = event.source as Node
            val stage = node.scene.window as Stage
            stage.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
