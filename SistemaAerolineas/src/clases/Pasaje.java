/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author anita
 */
public class Pasaje implements Comparable<Pasaje>{
    private String PasaporteCliente;
    private String CodigoVuelo;
    private int CategoriaPasaje;
    private String EstadoPasaje;
    
    
    public Pasaje(){}
    
    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje) {
        this.PasaporteCliente = pasaporteCliente;
        this.CodigoVuelo = codigoVuelo;
        this.CategoriaPasaje = categoriaPasaje;  
        this.EstadoPasaje = "CPR";
    }
    
    @Override
    public String toString() {
        return CodigoVuelo + "-" + EstadoPasaje;
    }

    public String getCodVuelo() {
        return this.CodigoVuelo;
    }
    
    public String getPasaporte() {
        return PasaporteCliente;
    }
    
    public String getEstado() {
        return EstadoPasaje;
    }
    
    public int getCategoria() {
        return CategoriaPasaje;
    }
    
    public void setEstado(String estado){
        this.EstadoPasaje = estado;
    }
    
    @Override
    public int compareTo(Pasaje o) {
        return this.getPasaporte().compareTo(o.getPasaporte());
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getPasaporte().equals(((Pasaje) obj).getPasaporte());
    }
     
}
