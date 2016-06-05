package edu.registro.persistencia;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.PublicKey;

import edu.registro.modelo.Usuario.Usuario;

/**
 * Created by jose.arangos on 2/06/16.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context) {
        super(context, UsuariosBD.BD_NAME, null, UsuariosBD.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        // creamos la tabla de usuarios
        sql = String.format("CREATE TABLE %s (%s INTEGER PRYMARY KEY AUTO_INCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                UsuariosBD.TABLE, Column.ID, Column.Nombre, Column.Correo, Column.Telefono, Column.Clave);

        //sentencia para crear la tabla
        Log.d(TAG, "onCreate with SQL: " + sql);
        db.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql;
        sql = String.format("DROP TABLE IF EXISTS %s", UsuariosBD.TABLE);
        // sentencia para borrar la tabla
        Log.d(TAG, "onUpdrage with SQL: " + sql);
        db.execSQL(sql);
        onCreate(db);
    }

    // insertar BD

    public void insertar(String tabla, ContentValues valores) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Se guarda la fila en la base de datos
        Log.d(TAG, "  ");
        try {
            db.insertWithOnConflict(tabla, null, valores, SQLiteDatabase.CONFLICT_IGNORE);
            Log.d(TAG, "Insertado en la base de datos");
        } catch (Exception ex) {
            Log.e(TAG, "Error al insertar en la base de datos");
        } finally {
            db.close();
        }
        Log.d(TAG, " PASE ");
    }
    // consultar en Bd

    public Usuario ConsultarUsuario(String user){
        Usuario usuario=null;// variable a retornar
        String[] campos= new String[]{Column.Correo,Column.Telefono,Column.Clave,Column.ID}; // campos donde se buscara
        String[] argumentos = new String[]{user}; //
        String consulta =Column.Nombre+"=?";
        SQLiteDatabase db=this.getWritableDatabase();
        try {
            Cursor c=db.query(UsuariosBD.TABLE,campos,consulta,argumentos,null,null,null);
            // validacion de almenos un registro
            if (c.moveToFirst()){
                // recorremos el cursor hasta que no hayan mas registros
                do {
                    usuario= new Usuario();
                    usuario.setNombre(user);
                    usuario.setEmail(c.getString(c.getColumnIndex(Column.Correo)));
                    usuario.setTelefono(c.getInt(c.getColumnIndex(Column.Telefono)));
                    usuario.setClave(c.getString(c.getColumnIndex(Column.Clave)));
                }while (c.moveToNext());
                Log.d(TAG, "Se ha consultado en la base de datos");
            }else{
                Log.d(TAG,"No hay registro");
            }
            c.close();
        }catch (Exception ex){
            Log.e(TAG, "Error al consultar en la base de datos");
        }finally {
            db.close();
        }

        return usuario;
    }


}





























































