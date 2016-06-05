package edu.registro.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import edu.registro.R;
import edu.registro.modelo.Controlador.ModeloControlador;
import edu.registro.modelo.Usuario.Usuario;

public class inicio extends AppCompatActivity {

    private Button btingresar;
    TextView btregistrate;

    @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btingresar=(Button)findViewById(R.id.btingresar);
        btregistrate=(TextView)findViewById(R.id.btRegistrarme);

        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr = ((EditText) findViewById(R.id.txtUsuario)).getText().toString();
                String clave = ((EditText) findViewById(R.id.txtclave)).getText().toString();
                ModeloControlador modeloControlador = new ModeloControlador(inicio.this);

                // validacion contraseña en la  base de datos
                if (modeloControlador.validarContraseña(usr, clave)) {
                    Intent i = new Intent(inicio.this, Perfil.class);
                    Usuario usuario = modeloControlador.getUsuario(usr);
                    i.putExtra("Usuario",usuario);
                    startActivity(i);
                }

            }
        });
        btregistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(inicio.this,Registrarse.class);
                startActivity(i);
            }
        });







    }
}
