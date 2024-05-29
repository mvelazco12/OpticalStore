package com.mateovelazco.projekt;
public class ListaObjetos {
    private Object adicion;
    private String agudezaa;
    private double cilindro;
    private int ejee;
    private double esfera;
    private int filtro;
    private String name;
    private String tipolentes;

    private String ojos;

    // Default constructor required for calls to DataSnapshot.getValue(ListaObjetos.class)
    public ListaObjetos() {
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    // Getters and setters
    public Object getAdicion() {
        return adicion;
    }

    public void setAdicion(int adicion) {
        this.adicion = adicion;
    }

    public String getAgudezaa() {
        return agudezaa;
    }

    public void setAgudezaa(String agudezaa) {
        this.agudezaa = agudezaa;
    }

    public double getCilindro() {
        return cilindro;
    }

    public void setCilindro(double cilindro) {
        this.cilindro = cilindro;
    }

    public int getEjee() {
        return ejee;
    }

    public void setEjee(int ejee) {
        this.ejee = ejee;
    }

    public double getEsfera() {
        return esfera;
    }

    public void setEsfera(double esfera) {
        this.esfera = esfera;
    }

    public int getFiltro() {
        return filtro;
    }

    public void setFiltro(int filtro) {
        this.filtro = filtro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipolentes() {
        return tipolentes;
    }

    public void setTipolentes(String tipolentes) {
        this.tipolentes = tipolentes;
    }

    @Override
    public String toString() {
        return "Fecha: " + name + "\nOjo: "+ ojos +"\nAdicion: " + adicion + "\nAgudeza: " + agudezaa +
                "\nCilindro: " + cilindro + "\nEje: " + ejee + "\nEsfera: " + esfera +
                "\nFiltro: " + filtro + "\nTipo de Lentes: " + tipolentes ;                // Display the name in the ListView
    }
}
