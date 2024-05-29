package com.mateovelazco.projekt;

public class Pojodate {

    String fecha;
    String hora;

    public Pojodate(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public Pojodate() {


    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String toString(){
        return  "Fecha: " + fecha + "\n Hora" + hora;
    }
}
