package edu.registro.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import edu.registro.R;
import edu.registro.modelo.Usuario.Usuario;

public class Perfil extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //Bundle bundle=getIntent().getExtras();
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("Usuario");
        EditText nombre=(EditText)findViewById(R.id.editxtnombre);
        EditText celular =(EditText)findViewById(R.id.editxtcelular);
        EditText correo =(EditText)findViewById(R.id.editxtcorreo);
        // llenamos
        nombre.setText(usuario.getNombre());
        celular.setText(Integer.toString(usuario.getTelefono()));
        correo.setText(usuario.getEmail());



    }
}
