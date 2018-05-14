package com.facundoalvarado.cuchanoble_android.Model;

/**
 * Created by Facundo on 02/07/2018.
 */

public class ListItem {

//    Campos que llenar en los items
    private String direccion;
    private String tamano;
    private String sexo;
    private String edad;
    private String estado;
    private String contacto;
    private String imagen;



    public ListItem(String direccion, String tamano, String sexo, String edad, String estado, String contacto, String imagen) {
        this.direccion = direccion;
        this.tamano = tamano;
        this.sexo = sexo;
        this.edad = edad;
        this.estado = estado;
        this.contacto = contacto;
        this.imagen = imagen;
    }


//    Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}


