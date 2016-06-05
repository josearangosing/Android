package edu.registro.modelo.Controlador;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import edu.registro.modelo.Usuario.Usuario;
import edu.registro.persistencia.Column;
import edu.registro.persistencia.DbHelper;
import edu.registro.persistencia.UsuariosBD;
import edu.registro.vista.Perfil;
import edu.registro.vista.inicio;

/**
 * Created by cristian.marind on 2/06/16.
 */
public class ModeloControlador {
    public  Context context;

    public ModeloControlador(Context context) {
        this.context=context;
    }

    public void registrarUsuario(String clave,String correo,String nombre, int tele){
        Usuario usuario=new Usuario(clave,correo,nombre,tele);
        DbHelper dbHelper= new DbHelper(context);
        ContentValues values=new ContentValues();
        // values.put(Column.ID,Integer.toString(usuario.getId()));
        values.put(Column.Clave,usuario.getClave());
        values.put(Column.Correo,usuario.getEmail());
        values.put(Column.Nombre,usuario.getNombre());
        values.put(Column.Telefono,Integer.toString(usuario.getTelefono()));
        dbHelper.insertar(UsuariosBD.TABLE, values);// inserta
    }


    public Usuario getUsuario(String user){
        Usuario usuario;
        DbHelper dbHelper= new DbHelper(context);
        usuario=dbHelper.ConsultarUsuario(user);
        return usuario;
    }

    public boolean validarContraseña(String user, String contraseña){
        Usuario usuario= getUsuario(user);
        if(usuario != null){
            if (usuario.getClave().equals(contraseña)){
                return true;
            }
        }else{
            Log.d("Hola", "Usuario null");
        }
        return false;
    }
}
