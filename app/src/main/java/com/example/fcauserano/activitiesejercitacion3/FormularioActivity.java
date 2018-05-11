package com.example.fcauserano.activitiesejercitacion3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtLastName;
    EditText edtAge;
    EditText edtCareer;
    EditText edtMail;
    Button btnSend;
    CheckBox chkTorneo;
    CheckBox chkMeetup;
    CheckBox chkAsado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        edtName = findViewById(R.id.edtFormularioName);
        edtLastName = findViewById(R.id.edtFormularioLastName);
        edtAge = findViewById(R.id.edtFormularioAge);
        edtCareer = findViewById(R.id.edtFormularioCareer);
        edtMail = findViewById(R.id.edtFormularioMail);
        btnSend = findViewById(R.id.btnFormularioSend);
        chkTorneo = findViewById(R.id.chkFormularioTorneo);
        chkMeetup = findViewById(R.id.chkFormularioMeetup);
        chkAsado = findViewById(R.id.chkFormularioAsado);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarDatosCompletos() && validar(edtName, 2) && validar(edtLastName, 2) && validar(edtCareer, 3) && validarEdad() && validarMail()) {
                    Toast.makeText(FormularioActivity.this, "Todo validado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FormularioActivity.this, EnvioActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(EnvioActivity.CLAVE_NOMBRE, edtName.getText().toString());
                    bundle.putString(EnvioActivity.CLAVE_APELLIDO, edtLastName.getText().toString());
                    bundle.putString(EnvioActivity.CLAVE_EDAD, edtAge.getText().toString());
                    bundle.putString(EnvioActivity.CLAVE_CARREER, edtCareer.getText().toString());
                    bundle.putString(EnvioActivity.CLAVE_MAIL, edtMail.getText().toString());
                    bundle.putString(EnvioActivity.CLAVE_SELECCION, checkBoxSeleccionados());
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    Toast.makeText(FormularioActivity.this, "La cagaste!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean validarDatosCompletos() {
        if (TextUtils.isEmpty(edtName.getText()) || TextUtils.isEmpty(edtLastName.getText()) || TextUtils.isEmpty(edtAge.getText()) || TextUtils.isEmpty(edtCareer.getText()) || TextUtils.isEmpty(edtMail.getText())) {
            Toast.makeText(FormularioActivity.this, "Falta completar informacion!!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private Boolean validar(EditText edt, Integer longitud) {
        if (edt.getText().toString().length() <= longitud) {
            Toast.makeText(FormularioActivity.this, "Nombre y Apellido deben contener al menos 3 letras. Carrera debe contener al menos 6.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private Boolean validarEdad() {
        if (Integer.parseInt(edtAge.getText().toString()) >= 7 && Integer.parseInt(edtAge.getText().toString()) <= 100) {
            return true;
        } else {
            Toast.makeText(this, "La edad debe ser entre 7 y 100 años.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private Boolean validarMail() {
        if (!(edtMail.getText().toString().contains("@"))) {
            Toast.makeText(this, "El email no es valido.", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private String checkBoxSeleccionados() {
        String result = "";
        if (chkAsado.isChecked()) {
            result +=  chkAsado.getText().toString() + " ";
        }
        if (chkMeetup.isChecked()) {
            result += chkMeetup.getText().toString() + " ";
        }
        if (chkTorneo.isChecked()) {
            result += chkTorneo.getText().toString() + " ";
        }
        return result;
    }
}
