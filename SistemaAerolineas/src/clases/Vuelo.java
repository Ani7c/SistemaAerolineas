/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import tads.Cola;
import tads.Lista;
/**
 *
 * @author anita
 */
public class Vuelo implements Comparable<Vuelo> {  
    private String CodigoVuelo;
    private Aerolinea Aerolinea;
    private Avion Avion;
    private String PaisDestino;
    public int Dia;
    public int Mes;
    public int Año;
    public int CantPasajesEcon;
    public int CantPasajesPClase;
    public Lista<Pasaje> pasajesVendidos;
    public Cola<Cliente> colaEconomica;
    public Cola<Cliente> colaPClase;


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
        this.pasajesVendidos = new Lista<>();
        this.colaEconomica = new Cola<>();
        this.colaPClase = new Cola<>();
        
    }
    
    public Vuelo(String codigoVuelo) {
        this.CodigoVuelo = codigoVuelo;
        this.pasajesVendidos = new Lista<>();
        this.colaEconomica = new Cola<>();
        this.colaPClase = new Cola<>();
    }
    
//    public void setPasajeVendido(Pasaje pasaje){
//        this.pasajesVendidos.agregarFinal(pasaje);
//    }
    
    public void agregarAListaDeEsperaEcon(Cliente cliente){
        this.colaEconomica.encolar(cliente);
    }
    public void agregarAListaDeEsperaPClase(Cliente cliente){
         this.colaPClase.encolar(cliente);
    }
    
    public Cliente eliminarDeListaDeEsperaEcon(){
        return this.colaEconomica.desencolar();
    }
    
    public Cliente eliminarDeListaDeEsperaPClase(){
        return this.colaPClase.desencolar();
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
    
    @Override
    public boolean equals(Object obj) {
        return this.getCodVuelo().equals(((Vuelo) obj).getCodVuelo());
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.getCodVuelo().compareTo(o.getCodVuelo());
    }
   

    
    public boolean mismaFecha(int dia, int mes, int año) {
        return this.Dia == dia && this.Mes == mes && this.Año == año;
    }

    public void setDestino(String paisDestino) {
        this.PaisDestino = paisDestino;
    }

    public void setFecha(int dia, int mes, int año) {
        this.Dia = dia;
        this.Mes = mes;
        this.Año = año;
                
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.CantPasajesEcon = cantPasajesEcon;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.CantPasajesPClase = cantPasajesPClase;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.Aerolinea = aerolinea;
    }

    public void setAvion(Avion avion) {
        this.Avion = avion;
    }
}
