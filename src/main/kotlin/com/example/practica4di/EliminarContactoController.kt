package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.stage.Stage
import java.io.IOException

class EliminarContactoController {
    // Función que se ejecuta al hacer clic en el botón "Volver"
    @FXML
    private fun onVolverButtonClick(event: ActionEvent) {
        try {
            // Obtener el nodo fuente (en este caso, el botón)
            val node = event.source as Node

            // Obtener la ventana actual y cerrarla
            val stage = node.scene.window as Stage
            stage.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}