/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author anita
 */
public class Vuelo {  
    public String CodigoVuelo;
    public String Aerolinea;
    public String CodAvion;
    public String PaisDestino;
    public int Dia;
    public int Mes;
    public int Año;
    public int CantPasajesEcon;
    public int CantPasajesPClase;
    
    public Vuelo(){}
    
    public Vuelo(String CodigoVuelo, String Aerolinea, String CodAvion, String PaisDestino, int Dia, int Mes, int Año, int CantPasajesEcon, int CantPasajesPClase) {
        this.CodigoVuelo = CodigoVuelo;
        this.Aerolinea = Aerolinea;
        this.CodAvion = CodAvion;
        this.PaisDestino = PaisDestino;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.CantPasajesEcon = CantPasajesEcon;
        this.CantPasajesPClase = CantPasajesPClase;
    }
    
    public String getCodVuelo() {
        return this.CodigoVuelo;
    }
    
    public String getAerolinea() {
        return this.Aerolinea;
    }
    
    public String getCodAvion() {
        return this.CodAvion;
    }
    
    public String getPaisDestino() {
        return this.PaisDestino;
    }
    
    
    //mejorar fecha
}
