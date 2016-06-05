package edu.registro.modelo.Usuario;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by cristian.marind on 2/06/16.
 */
public class Usuario implements Serializable {
    private String email;
    private String clave;
    private String nombre;
    private int    telefono;
    public Usuario(String clave, String email, String nombre, int telefono) {
        this.clave=clave;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
