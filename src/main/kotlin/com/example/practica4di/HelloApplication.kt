package com.example.practica4di

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    // Sobrescritura del método start para configurar la escena y mostrarla en una ventana
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("vista-principal.fxml")) // Cargar el archivo FXML
        val scene = Scene(fxmlLoader.load(), 600.0, 400.0) // Crear la escena con el objeto FXMLLoader y establecer dimensiones
        stage.title = "Práctica 4 Desarrollo de Interfaces" // Establecer el título de la ventana
        stage.scene = scene // Establecer la escena en la ventana
        stage.isResizable = true // Hacer que la ventana sea redimensionable
        stage.show() // Mostrar la ventana
    }
}
fun main() {
    Application.launch(HelloApplication::class.java)
}
