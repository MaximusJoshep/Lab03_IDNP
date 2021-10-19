package com.lab02.JoseMejia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lab02.JoseMejia.R;
import com.lab02.JoseMejia.View.MainActivity;
import com.lab02.JoseMejia.ViewModel.ViewModelVisitadores;

import java.io.Serializable;

public class Paciente extends AppCompatActivity implements View.OnClickListener {
    EditText dni,nombres,direccion;
    Button button_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);
        dni=(EditText) findViewById(R.id.dni);
        nombres=(EditText) findViewById(R.id.nombre);
        direccion=(EditText) findViewById(R.id.direcccion);
        button_registrar = (Button)findViewById(R.id.registrar);
        button_registrar.setOnClickListener(this);
    }
    // Implement the OnClickListener callbacks
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.registrar:
                Intent in=new Intent(this, MainActivity.class);
                Bundle bundle = new Bundle();
                ViewModelVisitadores viewm = new ViewModelVisitadores();
                viewm.registrarPaciente(nombres.getText().toString(),dni.getText().toString(),direccion.getText().toString());
                System.out.println(nombres.getText().toString());

                bundle.putSerializable("paciente",viewm);

                in.putExtras(bundle);

                startActivityForResult(in,222);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}