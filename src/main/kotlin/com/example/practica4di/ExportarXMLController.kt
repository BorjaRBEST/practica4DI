package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class ExportarXMLController {

    private val gestorDeContactos = GestorDeContactos.getInstance()

    @FXML
    private lateinit var tfExportarXML: TextField

    @FXML
    private lateinit var tfResultadoExportarXML: TextField

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
    private fun onExportarXMLButtonClick(event: ActionEvent) {
        val rutaArchivo = tfExportarXML.text
        try {
            gestorDeContactos.exportarContactosAXML(rutaArchivo)
            tfResultadoExportarXML.text = "Contactos exportados con éxito"
        } catch (e: Exception) {
            tfResultadoExportarXML.text = "Error al exportar contactos ${e.message}"
        }
    }
}
