package com.lab02.JoseMejia.ViewModel;

import com.lab02.JoseMejia.Model.Paciente;
import com.lab02.JoseMejia.Model.Visita;
import java.io.Serializable;

@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class ViewModelVisitadores implements Serializable{

    private Paciente paciente;
    private Visita visita;
    public ViewModelVisitadores()
    {
        this.paciente=new Paciente();
        this.visita=new Visita();
    }
    public ViewModelVisitadores(String nombre, String dni, String direccion)
    {
        this.paciente=new Paciente(nombre,dni,direccion);
    }

    public void registrarPaciente(String nombre, String dni, String direccion){
        paciente.setNombre(nombre);
        paciente.setDni(dni);
        paciente.setDireccion(direccion);
    }
    public void setPaciente(Paciente p)
    {
        this.paciente=p;
    }
    public void setVisita(Visita v)
    {
        this.visita=v;
    }

    public void registrarVisita(String peso, String presion, String saturacion, String temperatura){

        visita.setPeso(peso);
        visita.setPresion(presion);
        visita.setSaturacion(saturacion);
        visita.setTemperatura(temperatura);
    }

    public String getDataPaciente(){
        String data = "Datos del paciente: "+paciente.getNombre()+"\n DNI:"+paciente.getDni()+"\n Direccion:"+paciente.getDireccion()+"\n";
        return data;
    }

    public String getDataVisita(){
        String data = "\n Peso:"+visita.getPeso() +"\n Presion:" +visita.getPresion() + "\n Saturacion:"+visita.getSaturacion() +"\n Temperatura:"+visita.getTemperatura();
        return data;
    }
}
