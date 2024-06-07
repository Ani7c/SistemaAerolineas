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
public class Vuelo implements Comparable<Vuelo>{  
    private String CodigoVuelo;
    private Aerolinea Aerolinea;
    private Avion Avion;
    private String PaisDestino;
    public int Dia;
    public int Mes;
    public int Año;
    public int CantPasajesEcon;
    public int CantPasajesPClase;
    private Lista<Pasaje> pasajesVendidos;

    public Vuelo(){}
    
    public Vuelo(String CodigoVuelo, Aerolinea Aerolinea, Avion Avion, String PaisDestino, int Dia, int Mes, int Año, int CantPasajesEcon, int CantPasajesPClase) {
        this.CodigoVuelo = CodigoVuelo;
        this.Aerolinea = Aerolinea;
        this.Avion = Avion;
        this.PaisDestino = PaisDestino;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.CantPasajesEcon = CantPasajesEcon;
        this.CantPasajesPClase = CantPasajesPClase;
    }

    public Vuelo(String codigoVuelo) {
        this.CodigoVuelo = codigoVuelo;
    }
    
    public String getCodVuelo() {
        return this.CodigoVuelo;
    }
    
    public Aerolinea getAerolinea() {
        return this.Aerolinea;
    }
    
    public Avion getAvion() {
        return this.Avion;
    }
    
    public String getPaisDestino() {
        return this.PaisDestino;
    }
    
    public Lista<Pasaje> getPasajesVendidos() {
        return this.pasajesVendidos;
    }
     
    //mejorar fecha

    @Override
    public int compareTo(Vuelo o) {
        return this.getCodVuelo().compareTo(o.getCodVuelo()); // Comparar los códigos normalmente
    }
    
    public boolean mismaFecha(int dia, int mes, int año) {
        return this.Dia == dia && this.Mes == mes && this.Año == año;
    }
}
