package com.example.practica4di

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("vista-principal.fxml"))
        val scene = Scene(fxmlLoader.load(), 450.0, 400.0)
        stage.title = "Práctica 4 Desarrollo de Interfaces"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}