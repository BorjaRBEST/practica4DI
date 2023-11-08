package com.example.practica4di

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.File

class GestorDeContactosTest {

    private val gestorDeContactos = GestorDeContactos.getInstance()

    // Pruebas unitarias para el método de agregar contacto
    @Test
    fun agregarContacto() {
        val contacto = Contacto("Borja", "Rodríguez", 123456789, "borjaalumno@medac.es")
        gestorDeContactos.agregarContacto(contacto)
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        assertTrue(listaDeContactos.contains(contacto))
    }

    // Pruebas unitarias para el método de editar contacto
    @Test
    fun actualizarContacto() {
        val contacto = Contacto("Borja", "Rodríguez", 123456789, "borjaalumno@medac.es")
        val nuevoCorreo = "johndoe@example.com"
        val exito = gestorDeContactos.actualizarContacto(contacto.correo, contacto.nombre, contacto.apellido, contacto.telefono, nuevoCorreo)
        assertTrue(exito)
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        val contactoActualizado = listaDeContactos.find { it.correo == nuevoCorreo }
        assertNotNull(contactoActualizado)
    }

    // Pruebas unitarias para el método de eliminar contacto
    @Test
    fun eliminarContacto() {
        val contacto = Contacto("Borja", "Rodríguez", 123456789, "borjaalumno@medac.es")
        gestorDeContactos.agregarContacto(contacto)
        val exito = gestorDeContactos.eliminarContacto(contacto.correo)
        assertTrue(exito)
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        assertTrue(listaDeContactos.contains(contacto))
    }

    // Pruebas unitarias para el método de listar contactos
    @Test
    fun getListaDeContactos() {
        val listaDeContactos = gestorDeContactos.getListaDeContactos()
        assertNotNull(listaDeContactos)
    }

    // Pruebas unitarias para el método de exportación a archivo xml
    @Test
    fun exportarContactosAXML() {
        val rutaArchivo = "contactos.xml"
        gestorDeContactos.exportarContactosAXML(rutaArchivo)
        val archivo = File(rutaArchivo)
        assertTrue(archivo.exists())
        archivo.delete()
    }
}
