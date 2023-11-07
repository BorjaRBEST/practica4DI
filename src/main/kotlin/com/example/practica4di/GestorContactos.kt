package com.example.practica4di

class GestorDeContactos() {

    private val listaDeContactos = mutableListOf<Contacto>()

    companion object {
        private var instance: GestorDeContactos? = null

        fun getInstance(): GestorDeContactos {
            if (instance == null) {
                instance = GestorDeContactos()
            }
            return instance as GestorDeContactos
        }
    }
    fun agregarContacto(contacto: Contacto) {
        listaDeContactos.add(contacto)
    }

    fun actualizarContacto(idCorreo: String, nombre: String, apellido: String, telefono: Int, correo: String) {
        val contacto = listaDeContactos.find { it.correo == idCorreo }
        if (contacto != null) {
            contacto.nombre = nombre
            contacto.apellido = apellido
            contacto.telefono = telefono
            contacto.correo = correo
        }
    }

    // Otros métodos para editar, eliminar y listar contactos

    fun getListaDeContactos(): List<Contacto> {
        return listaDeContactos
    }
}
