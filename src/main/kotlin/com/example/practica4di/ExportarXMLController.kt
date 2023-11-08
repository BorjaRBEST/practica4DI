package com.example.practica4di

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.stage.Stage
import java.io.IOException

class ExportarXMLController {

    // Instancia del gestor de contactos
    private val gestorDeContactos = GestorDeContactos.getInstance()


    @FXML
    private lateinit var tfExportarXML: TextField

    @FXML
    private lateinit var tfResultadoExportarXML: TextField

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

    // Método que se ejecuta al hacer clic en el botón de exportar XML
    @FXML
    private fun onExportarXMLButtonClick(event: ActionEvent) {
        // Obtener la ruta del archivo de la entrada de texto
        val rutaArchivo = tfExportarXML.text
        try {
            // Intentar exportar los contactos a XML y mostrar el resultado
            gestorDeContactos.exportarContactosAXML(rutaArchivo)
            tfResultadoExportarXML.text = "Contactos exportados con éxito"
        } catch (e: Exception) {
            tfResultadoExportarXML.text = "Error al exportar contactos ${e.message}"
        }
    }
}
