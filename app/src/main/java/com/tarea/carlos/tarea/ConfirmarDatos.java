package com.tarea.carlos.tarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvnombre, tvtelefono, tvdescripcion, tvemail, tvnacimiento;
    private Button btneditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvnombre = (TextView) findViewById(R.id.tvNombre);
        tvtelefono = (TextView) findViewById(R.id.tvTelefono);
        tvemail = (TextView) findViewById(R.id.tvEmail);
        tvnacimiento = (TextView) findViewById(R.id.tvFecha);
        tvdescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btneditar = (Button) findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.texto_nombre));
        String fecha = parametros.getString(getResources().getString(R.string.texto_nacimiento));
        String telefono = parametros.getString(getResources().getString(R.string.texto_telefono));
        String email = parametros.getString(getResources().getString(R.string.texto_email));
        String descripcion = parametros.getString(getResources().getString(R.string.texto_descripcion));

        tvnombre.setText(nombre);
        tvnacimiento.setText("Fecha de Nacimiento: " + fecha);
        tvtelefono.setText("Tel: " + telefono);
        tvemail.setText("Email: " + email);
        tvdescripcion.setText("Descripción: " + descripcion);

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
