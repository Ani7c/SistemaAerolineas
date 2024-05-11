/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author anita
 */
public class Avion implements Comparable<Avion>{
    private String Codigo;
    private int CapacidadMax;
    private String NomAerolinea;
    
    public Avion(){};

    public Avion(String Codigo, int CapacidadMax, String NomAerolinea) {
        this.Codigo = Codigo;
        this.CapacidadMax = CapacidadMax;
        this.NomAerolinea = NomAerolinea;
    }
    
    public String getCodigo() {
        return Codigo;
    }
    
    public int getCapacidadMax() {
        return CapacidadMax;
    }
    
    public String getNomAerolinea() {
        return NomAerolinea;
    }
    
    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }
    
    public void setCapacidadMax(int capacidadMax) {
        this.CapacidadMax = capacidadMax;
    }
    
    public void setNomAerolinea(String nomAerolinea) {
        this.NomAerolinea = nomAerolinea;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getCodigo().equals(((Avion) obj).getCodigo());
    }

    @Override
    public int compareTo(Avion o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public String toString() {
        return this.getCodigo() +"-"+ this.getCapacidadMax() +"|";
    }
}
