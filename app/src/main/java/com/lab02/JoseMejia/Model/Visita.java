package com.lab02.JoseMejia.Model;

public class Visita {
    private String peso;
    private String presion;
    private String saturacion;
    private String temperatura;

    public Visita(String peso, String presion, String saturacion, String temperatura){
        this.peso = peso;
        this.presion = presion;
        this.saturacion = saturacion;
        this.temperatura = temperatura;
    }
    //getters
    public String getPeso() {
        return peso;
    }

    public String getPresion() {
        return presion;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public String getTemperatura() {
        return temperatura;
    }
    //setters
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
