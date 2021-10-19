package com.lab02.JoseMejia.ViewModel;

import com.lab02.JoseMejia.MainActivity;
import com.lab02.JoseMejia.Model.Paciente;
import com.lab02.JoseMejia.Model.Visita;

public class ViewModelVisitadores {

    private Paciente paciente;
    private Visita visita;

    public void registrarPaciente(String nombre, String dni, String direccion){
        paciente.setNombre(nombre);
        paciente.setDni(dni);
        paciente.setDireccion(direccion);
    }

    public void registrarVisita(String peso, String presion, String saturacion, String temperatura){
        visita.setPeso(peso);
        visita.setPresion(presion);
        visita.setSaturacion(saturacion);
        visita.setTemperatura(temperatura);
    }

    public String[] getDataPaciente(){
        String data[] = {paciente.getNombre() + paciente.getDni() + paciente.getDireccion()};
        return data;
    }

    public String[] getDataVisita(){
        String data[] = {visita.getPeso() + visita.getPresion() + visita.getSaturacion() + visita.getTemperatura()};
        return data;
    }
}
