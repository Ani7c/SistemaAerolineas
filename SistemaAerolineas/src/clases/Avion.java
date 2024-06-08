/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import tads.Lista;

/**
 *
 * @author anita
 */
public class Avion implements Comparable<Avion>{
    private String Codigo;
    private int CapacidadMax;
    private Aerolinea Aerolinea;
    private Lista<Vuelo> listaVuelos;
    
    public Avion(){};

    public Avion(String Codigo, int CapacidadMax, Aerolinea Aerolinea) {
        this.Codigo = Codigo;
        this.CapacidadMax = CapacidadMax;
        this.Aerolinea = Aerolinea;
        this.listaVuelos = new Lista<Vuelo>();
    }

    public Avion(String codAvion) {
        this.Codigo = codAvion;
    }
    
    public String getCodigo() {
        return Codigo;
    }
    
    public int getCapacidadMax() {
        return CapacidadMax;
    }
    
    public Aerolinea getAerolinea() {
        return Aerolinea;
    }
    
    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }
    
    public void setCapacidadMax(int capacidadMax) {
        this.CapacidadMax = capacidadMax;
    }
    
    public void setAerolinea(Aerolinea Aerolinea) {
        this.Aerolinea = Aerolinea;
    }
    
    public Lista<Vuelo> getListaVuelos() {
        return this.listaVuelos;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getCodigo().equals(((Avion) obj).getCodigo());
    }

    @Override
    public int compareTo(Avion o) {
        return this.getCodigo().compareTo(o.getCodigo());
    }
    
     @Override
    public String toString() {
        return this.getCodigo() +"-"+ this.getCapacidadMax() +"|";
    }
}
