package com.lab02.JoseMejia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.lab02.JoseMejia.ViewModel.ViewModelVisitadores;
import com.lab02.JoseMejia.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_paciente,button_visita,button_enviar;
    String dni,nombres,direccion,peso,presion,saturacion,temperatura;
    TextView info;
    EditText email;
    ViewModelVisitadores obj;
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
        obj= (ViewModelVisitadores) getIntent().getSerializableExtra("paciente");
        if(obj!=null)
        {
            info.setText(obj.getDataPaciente()+obj.getDataVisita());
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
                Bundle bundle = new Bundle();
                bundle.putSerializable("paciente",obj);
                intent.putExtras(bundle);
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