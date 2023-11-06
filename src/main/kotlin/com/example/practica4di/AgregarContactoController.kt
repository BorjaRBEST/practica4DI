package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class AgregarContactoController {

    @FXML
    private lateinit var labelNombre: Label

    @FXML
    private lateinit var labelApellidos: Label

    @FXML
    private lateinit var labelTelefono: Label

    @FXML
    private lateinit var labelCorreo: Label

    @FXML
    private lateinit var tfNombre: TextField

    @FXML
    private lateinit var tfApellidos: TextField

    @FXML
    private lateinit var tfTelefono: TextField

    @FXML
    private lateinit var tfCorreo: TextField

    @FXML
    private lateinit var buttonRegistrar: Button

    @FXML
    private lateinit var buttonVolver: Button

    @FXML
    private lateinit var tfResultado: TextField

    private lateinit var gestorDeContactos: GestorDeContactos

    fun setGestorDeContactos(gestorDeContactos: GestorDeContactos) {
        this.gestorDeContactos = gestorDeContactos
    }

    @FXML
    fun onRegistrarButtonClick(event: ActionEvent) {
        if (::gestorDeContactos.isInitialized) {
            val nombre = tfNombre.text
            val apellidos = tfApellidos.text
            val telefono = try {
                tfTelefono.text.toInt()
            } catch (e: NumberFormatException) {
                0
            }
            val correo = tfCorreo.text

            val contacto = Contacto(nombre, apellidos, telefono, correo)

            gestorDeContactos.agregarContacto(contacto)

            tfResultado.text = "Contacto registrado correctamente: $nombre $apellidos"
        }
    }

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
    fun initialize() {
        // Inicializa gestorDeContactos aquí si es necesario
        this.gestorDeContactos = GestorDeContactos()
    }
}
