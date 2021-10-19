package com.lab02.JoseMejia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lab02.JoseMejia.R;
import com.lab02.JoseMejia.View.MainActivity;
import com.lab02.JoseMejia.ViewModel.ViewModelVisitadores;

public class Visita extends AppCompatActivity implements View.OnClickListener {
    EditText peso,presion,saturacion,temperatura;
    Object[] datos=new Object[4];
    Button guardar;
    TextView info_paciente;
    String dni,nombres,direccion;
    ViewModelVisitadores obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
        peso=(EditText) findViewById(R.id.peso);
        presion=(EditText) findViewById(R.id.presion);
        saturacion=(EditText) findViewById(R.id.saturacion);
        temperatura=(EditText) findViewById(R.id.temperatura);
        obj= (ViewModelVisitadores) getIntent().getSerializableExtra("paciente");
        info_paciente = (TextView)findViewById(R.id.info);
        guardar = (Button)findViewById(R.id.guardar);
        guardar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.guardar:
                Intent in=new Intent(this, MainActivity.class);
                Bundle bundle1 = new Bundle();
                ViewModelVisitadores viewm = new ViewModelVisitadores();
                viewm=obj;
                viewm.registrarVisita(peso.getText().toString(),presion.getText().toString(),
                        saturacion.getText().toString(),temperatura.getText().toString());

                bundle1.putSerializable("paciente",viewm);
                in.putExtras(bundle1);
                startActivityForResult(in,222);
                break;
        }
    }
}