package com.example.practica4di

import java.io.FileWriter
import javax.xml.stream.XMLOutputFactory

class GestorDeContactos {

    // Lista de contactos
    private val listaDeContactos = mutableListOf<Contacto>()

    // Instancia única del gestor de contactos
    companion object {
        private var instance: GestorDeContactos? = null

        // Obtener la instancia del gestor de contactos
        fun getInstance(): GestorDeContactos {
            if (instance == null) {
                instance = GestorDeContactos()
            }
            return instance as GestorDeContactos
        }
    }

    // Agregar un contacto a la lista
    fun agregarContacto(contacto: Contacto) {
        listaDeContactos.add(contacto)
    }

    // Actualizar un contacto existente
    fun actualizarContacto(idCorreo: String, nombre: String, apellido: String, telefono: Int, correo: String): Boolean {
        val contacto = listaDeContactos.find { it.correo == idCorreo }
        return if (contacto != null) {
            contacto.nombre = nombre
            contacto.apellido = apellido
            contacto.telefono = telefono
            contacto.correo = correo
            true
        } else {
            false
        }
    }

    // Eliminar un contacto de la lista
    fun eliminarContacto(idCorreo: String): Boolean {
        val contacto = listaDeContactos.find { it.correo == idCorreo }
        return if (contacto != null) {
            listaDeContactos.remove(contacto)
            true
        } else {
            false
        }
    }

    // Obtener la lista de contactos
    fun getListaDeContactos(): List<Contacto> {
        return listaDeContactos
    }

    // Exportar la lista de contactos a un archivo XML en la ruta especificada
    fun exportarContactosAXML(rutaArchivo: String) {
        val xmlOutputFactory = XMLOutputFactory.newInstance()
        val xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(FileWriter(rutaArchivo))

        xmlStreamWriter.writeStartDocument()
        xmlStreamWriter.writeStartElement("contactos")

        for (contacto in listaDeContactos) {
            xmlStreamWriter.writeStartElement("contacto")
            xmlStreamWriter.writeAttribute("correo", contacto.correo)

            xmlStreamWriter.writeStartElement("nombre")
            xmlStreamWriter.writeCharacters(contacto.nombre)
            xmlStreamWriter.writeEndElement()

            xmlStreamWriter.writeStartElement("apellido")
            xmlStreamWriter.writeCharacters(contacto.apellido)
            xmlStreamWriter.writeEndElement()

            xmlStreamWriter.writeStartElement("telefono")
            xmlStreamWriter.writeCharacters(contacto.telefono.toString())
            xmlStreamWriter.writeEndElement()

            xmlStreamWriter.writeEndElement()
        }

        xmlStreamWriter.writeEndElement()
        xmlStreamWriter.writeEndDocument()
        xmlStreamWriter.flush()
        xmlStreamWriter.close()
    }
}