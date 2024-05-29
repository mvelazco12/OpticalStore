package com.mateovelazco.projekt;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Pacientes implements Parcelable {
    Float cilindro, esfera, adicion;
    Integer ejee, filtro;
    String agudezaa,tipolentes, name;


    public Pacientes(Float cilindro, Float esfera, Float adicion, Integer ejee, Integer filtro, String agudezaa, String tipolentes, String name, String ojo) {
        this.cilindro = cilindro;
        this.esfera = esfera;
        this.adicion = adicion;
        this.ejee = ejee;
        this.filtro = filtro;
        this.agudezaa = agudezaa;
        this.tipolentes = tipolentes;
        this.name = name;
    }

    public Pacientes() {
    }

    public void setCilindro(Float cilindro) {
        this.cilindro = cilindro;
    }

    public void setEsfera(Float esfera) {
        this.esfera = esfera;
    }

    public void setAdicion(Float adicion) {
        this.adicion = adicion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEjee(Integer ejee) {
        this.ejee = ejee;
    }

    public void setFiltro(Integer filtro) {
        this.filtro = filtro;
    }

    public void setAgudezaa(String agudezaa) {
        this.agudezaa = agudezaa;
    }

    public void setTipolentes(String tipolentes) {
        this.tipolentes = tipolentes;
    }

    public Float getCilindro() {
        return cilindro;
    }

    public Float getEsfera() {
        return esfera;
    }

    public Float getAdicion() {
        return adicion;
    }

    public Integer getEjee() {
        return ejee;
    }

    public Integer getFiltro() {
        return filtro;
    }

    public String getAgudezaa() {
        return agudezaa;
    }

    public String getTipolentes() {
        return tipolentes;
    }
    public String getName(){return name;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

    }
}
