package com.example.practica4di

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.File

class GestorDeContactosTest {

    private val gestorDeContactos = GestorDeContactos.getInstance()

    @Test
    fun agregarContacto() {
        val contacto = Contacto("John", "Doe", 123456789, "john.doe@example.com")
        gestorDeContactos.agregarContacto(contacto)
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        assertTrue(listaDeContactos.contains(contacto))
    }

    @Test
    fun actualizarContacto() {
        val contacto = Contacto("John", "Doe", 123456789, "john.doe@example.com")
        val nuevoCorreo = "johndoe@example.com"
        val exito = gestorDeContactos.actualizarContacto(contacto.correo, contacto.nombre, contacto.apellido, contacto.telefono, nuevoCorreo)
        assertTrue(exito)
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        val contactoActualizado = listaDeContactos.find { it.correo == nuevoCorreo }
        assertNotNull(contactoActualizado)
    }

    @Test
    fun eliminarContacto() {
        val contacto = Contacto("John", "Doe", 123456789, "john.doe@example.com")
        gestorDeContactos.agregarContacto(contacto)
        val exito = gestorDeContactos.eliminarContacto(contacto.correo)
        assertTrue(exito)
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        assertTrue(listaDeContactos.contains(contacto))
    }

    @Test
    fun getListaDeContactos() {
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        assertNotNull(listaDeContactos)
    }

    @Test
    fun exportarContactosAXML() {
        val rutaArchivo = "contactos.xml"
        gestorDeContactos.exportarContactosAXML(rutaArchivo)
        val archivo = File(rutaArchivo)
        assertTrue(archivo.exists())
        archivo.delete()
    }
}
