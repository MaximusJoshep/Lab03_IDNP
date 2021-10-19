package com.lab02.JoseMejia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_paciente,button_visita,button_enviar;
    String dni,nombres,direccion,peso,presion,saturacion,temperatura;
    TextView info;
    EditText email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText) findViewById(R.id.email);
        button_paciente = (Button) findViewById(R.id.paciente);
        button_paciente.setOnClickListener(this);
        button_visita = (Button) findViewById(R.id.visita);
        button_visita.setOnClickListener(this);
        button_enviar = (Button) findViewById(R.id.enviar);
        button_enviar.setOnClickListener(this);
        info = (TextView)findViewById(R.id.info);
        Bundle bundle=this.getIntent().getExtras();

        if(bundle!=null)
        {
            peso=bundle.getString("peso");
            presion=bundle.getString("presion");
            saturacion=bundle.getString("saturacion");
            temperatura=bundle.getString("temperatura");
            dni=bundle.getString("dni");
            nombres=bundle.getString("nombres");
            direccion=bundle.getString("direccion");
            info.setText("Datos del paciente: "+nombres+"\n DNI:"+dni+"\n Direccion:"+direccion+"\n Peso:"+peso+"\n Presion:"+presion
                    +"\n Saturacion:"+saturacion+"\n Temperatura:"+temperatura);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.paciente:
                Intent in = new Intent(this, Paciente.class);
                startActivity(in);
                break;
            case R.id.visita:
                Intent intent = new Intent(this, Visita.class);
                intent.putExtra("dni", dni);
                intent.putExtra("nombres", nombres);
                intent.putExtra("direccion", direccion);
                startActivityForResult(intent,222);
                break;
            case R.id.enviar:
                Intent correo = new Intent(Intent.ACTION_SEND);
                correo.putExtra(correo.EXTRA_EMAIL,
                        new String[] { email.getText().toString() });
                correo.putExtra(correo.EXTRA_SUBJECT, "Prueba");
                correo.putExtra(correo.EXTRA_TEXT, "Hola");
                correo.setType("message/rfc822");
                startActivity(
                        Intent
                                .createChooser(correo,
                                        "Elije un cliente de Correo:"));

                break;
        }
    }

}