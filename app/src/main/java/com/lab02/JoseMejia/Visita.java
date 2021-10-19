package com.lab02.JoseMejia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Visita extends AppCompatActivity implements View.OnClickListener {
    EditText peso,presion,saturacion,temperatura;
    Object[] datos=new Object[4];
    Button guardar;
    TextView info_paciente;
    String dni,nombres,direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
        peso=(EditText) findViewById(R.id.peso);
        presion=(EditText) findViewById(R.id.presion);
        saturacion=(EditText) findViewById(R.id.saturacion);
        temperatura=(EditText) findViewById(R.id.temperatura);

        info_paciente = (TextView)findViewById(R.id.info);
        dni = getIntent().getStringExtra("dni");
        nombres = getIntent().getStringExtra("nombres");
        direccion = getIntent().getStringExtra("direccion");
        guardar = (Button)findViewById(R.id.guardar);
        guardar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.guardar:
                Intent in=new Intent(this,MainActivity.class);
                Bundle bundle1 = new Bundle();

                datos[0]=peso.getText().toString();
                datos[1]=presion.getText().toString();
                datos[2]=saturacion.getText().toString();
                datos[3]=temperatura.getText().toString();

                bundle1.putString("dni",dni);
                bundle1.putString("nombres",nombres);
                bundle1.putString("direccion",direccion);
                bundle1.putString("peso", (String) datos[0]);
                bundle1.putString("presion",(String) datos[1]);
                bundle1.putString("saturacion",(String) datos[2]);
                bundle1.putString("temperatura",(String) datos[3]);
                in.putExtras(bundle1);
                startActivityForResult(in,222);
                break;
        }
    }
}