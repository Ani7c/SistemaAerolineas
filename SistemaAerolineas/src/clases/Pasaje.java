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
    public String PasaporteCliente;
    public String CodigoVuelo;
    public int CategoríaPasaje;
    
    public Pasaje(){}
    
    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        this.PasaporteCliente = pasaporteCliente;
        this.CodigoVuelo = codigoVuelo;
        this.CategoríaPasaje = categoríaPasaje;
    }

    @Override
    public int compareTo(Pasaje o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

     
}
