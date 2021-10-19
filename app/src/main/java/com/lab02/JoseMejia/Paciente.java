package com.lab02.JoseMejia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent in=new Intent(this,MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("dni",dni.getText().toString());
                bundle.putString("nombres",nombres.getText().toString());
                bundle.putString("direccion",direccion.getText().toString());
                in.putExtras(bundle);
                startActivityForResult(in,222);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}