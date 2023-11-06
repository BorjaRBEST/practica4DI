package com.example.practica4di

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.ListView
import javafx.stage.Stage
import java.io.IOException

class ListaContactosController {

    private lateinit var gestorDeContactos: GestorDeContactos

    @FXML
    lateinit var listUsuarios: ListView<String>

    @FXML
    lateinit var buttonVolver: Button

    @FXML
    lateinit var buttonListarUsuarios: Button

    @FXML
    fun initialize() {
        // Inicializar el gestor de contactos
        this.gestorDeContactos = GestorDeContactos()
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
    fun onListarUsuariosButtonClick(event: ActionEvent) {
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        val nombres = listaDeContactos.map { "${it.nombre} ${it.apellido}" }
        val items = FXCollections.observableArrayList(nombres)
        listUsuarios.items = items
    }
}
