package com.example.practica4di

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import javafx.event.ActionEvent
import java.io.IOException

class PrincipalController {

    @FXML
    private val imageView: ImageView? = null

    fun initialize() {
        val imagePath = "file:///C:/Users/Nomak/IdeaProjects/medac/practica4DI/images/medac.png"
        val image = Image(imagePath)
        imageView?.setImage(image)
    }

    @FXML
    private fun onAgregarContactoButtonClick(event: ActionEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("vista-agregar-contacto.fxml"))
            val parent = fxmlLoader.load<Parent>()
            val stage = Stage()
            stage.title = "Agregar Nuevo Contacto"
            stage.scene = Scene(parent, 600.0, 400.0)
            stage.show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    @FXML
    private fun onEditarContactoButtonClick(event: ActionEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("vista-editar-contacto.fxml"))
            val parent = fxmlLoader.load<Parent>()
            val stage = Stage()
            stage.title = "Editar Contacto Existente"
            stage.scene = Scene(parent, 600.0, 400.0)
            stage.show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    @FXML
    private fun onEliminarContactoButtonClick(event: ActionEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("vista-eliminar-contacto.fxml"))
            val parent = fxmlLoader.load<Parent>()
            val stage = Stage()
            stage.title = "Eliminar Contacto Existente"
            stage.scene = Scene(parent, 600.0, 400.0)
            stage.show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    @FXML
    private fun onListaContactosButtonClick(event: ActionEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("vista-lista-contacto.fxml"))
            val parent = fxmlLoader.load<Parent>()
            val stage = Stage()
            stage.title = "Mostrar Contactos Existentes"
            stage.scene = Scene(parent, 600.0, 400.0)
            stage.show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    @FXML
    private fun onExportarXMLButtonClick(event: ActionEvent) {
        try {
            val fxmlLoader = FXMLLoader(javaClass.getResource("vista-exportar-xml.fxml"))
            val parent = fxmlLoader.load<Parent>()
            val stage = Stage()
            stage.title = "Exportar Contactos a XML"
            stage.scene = Scene(parent, 600.0, 400.0)
            stage.show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
