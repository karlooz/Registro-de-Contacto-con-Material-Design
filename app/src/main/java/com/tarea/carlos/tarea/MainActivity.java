package com.tarea.carlos.tarea;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tiNombre;
    TextInputEditText tiTelefono, tiEmail, tiDescripcion;
    DatePicker dpNacimiento;
    Button btnsiguiente;
    String nombre, telefono, descripcion, email, nacimiento;
    int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiNombre = (TextInputEditText) findViewById(R.id.tiNombre);
        tiTelefono = (TextInputEditText) findViewById(R.id.tiTelefono);
        tiEmail = (TextInputEditText) findViewById(R.id.tiEmail);
        tiDescripcion = (TextInputEditText) findViewById(R.id.tiDescripcion);
        dpNacimiento = (DatePicker) findViewById(R.id.dpNacimiento);
        btnsiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerDatos();
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra(getResources().getString(R.string.texto_nombre), nombre);
                intent.putExtra(getResources().getString(R.string.texto_telefono), telefono);
                intent.putExtra(getResources().getString(R.string.texto_email), email);
                intent.putExtra(getResources().getString(R.string.texto_descripcion), descripcion);
                intent.putExtra(getResources().getString(R.string.texto_nacimiento), nacimiento);
                startActivity(intent);
                finish();
            }
        });
    }

    public void obtenerDatos(){
        nombre = tiNombre.getText().toString();
        telefono = tiTelefono.getText().toString();
        email = tiEmail.getText().toString();
        descripcion = tiDescripcion.getText().toString();
        dia = dpNacimiento.getDayOfMonth();
        mes = dpNacimiento.getMonth() + 1;
        año = dpNacimiento.getYear();
        nacimiento = dia + "/" + mes + "/" + año;
    }
}

