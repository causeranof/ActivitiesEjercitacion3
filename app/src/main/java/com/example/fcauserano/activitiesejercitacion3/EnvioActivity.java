package com.example.fcauserano.activitiesejercitacion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EnvioActivity extends AppCompatActivity {

    public static final String CLAVE_NOMBRE = "clave_nombre";
    public static final String CLAVE_APELLIDO = "clave_apellido" ;
    public static final String CLAVE_EDAD = "clave_edad";
    public static final String CLAVE_CARREER = "clave_carrera";
    public static final String CLAVE_MAIL = "clave_mail";
    public static final String CLAVE_SELECCION = "clave_seleccion";

    TextView txtName;
    TextView txtLastName;
    TextView txtAge;
    TextView txtCareer;
    TextView txtMail;
    TextView txtSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);

        txtName = findViewById(R.id.txtEnvioName);
        txtLastName = findViewById(R.id.txtEnvioLastName);
        txtAge = findViewById(R.id.txtEnvioAge);
        txtCareer = findViewById(R.id.txtEnvioCarrera);
        txtMail = findViewById(R.id.txtEnvioMail);
        txtSeleccion = findViewById(R.id.txtEnvioOptions);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        txtName.setText(bundle.getString(CLAVE_NOMBRE));
        txtLastName.setText(bundle.getString(CLAVE_APELLIDO));
        txtAge.setText(bundle.getString(CLAVE_EDAD));
        txtCareer.setText(bundle.getString(CLAVE_CARREER));
        txtMail.setText(bundle.getString(CLAVE_MAIL));
        txtSeleccion.setText(bundle.getString(CLAVE_SELECCION));
    }
}
