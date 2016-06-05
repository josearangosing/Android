package edu.registro.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.registro.R;
import edu.registro.modelo.Controlador.ModeloControlador;
import edu.registro.modelo.Usuario.Usuario;

public class Registrarse extends AppCompatActivity {

    Button btregistrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        btregistrame=(Button)findViewById(R.id.btRegistrarme);

        btregistrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  nombre=((EditText)findViewById(R.id.txtNombre)).getText().toString(); // capturamos el nombre
                String  correo=((EditText)findViewById(R.id.txtCorreo)).getText().toString();// correo
                EditText telefono=(EditText)findViewById(R.id.txtTelefono);                    // telefono
                int  tele=Integer.parseInt(telefono.getText().toString());                  // telefono
                String  clave=((EditText)findViewById(R.id.txtclave)).getText().toString(); // contraseña o clave

                // inserta en la base de datos.

                ModeloControlador modeloControlador= new ModeloControlador(Registrarse.this);
                modeloControlador.registrarUsuario(clave,correo,nombre,tele);
                Intent i=new Intent(Registrarse.this,inicio.class);
                startActivity(i);

            }
        });




    }
}
