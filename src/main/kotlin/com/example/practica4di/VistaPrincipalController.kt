package com.example.practica4di

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class VistaPrincipalController {

    @FXML
    private val imageView: ImageView? = null

    fun initialize() {
        val imagePath = "file:///C:/Users/Nomak/IdeaProjects/medac/practica4DI/images/medac.png"
        val image = Image(imagePath)
        imageView?.setImage(image)
    }
    @FXML
    private val welcomeText: Label? = null
    @FXML
    private fun onHelloButtonClick() {
        welcomeText!!.text = "Welcome to JavaFX Application!"
    }
}
