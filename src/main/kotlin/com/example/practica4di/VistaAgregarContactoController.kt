package com.example.practica4di

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.awt.event.ActionEvent
import java.io.IOException

class VistaAgregarContactoController {


    @FXML
    private val imageView: ImageView? = null

    fun initialize() {
        val imagePath = "file:///C:/Users/Nomak/IdeaProjects/medac/practica4DI/images/medac.png"
        val image = Image(imagePath)
        imageView?.setImage(image)
    }

}