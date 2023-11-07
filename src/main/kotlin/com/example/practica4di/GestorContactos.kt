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
    fun eliminarContacto(idCorreo: String): Boolean {
        val contacto = listaDeContactos.find { it.correo == idCorreo }
        return if (contacto != null) {
            listaDeContactos.remove(contacto)
            true
        } else {
            false
        }
    }
    fun getListaDeContactos(): List<Contacto> {
        return listaDeContactos
    }
}
