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
public class Cliente implements Comparable<Cliente> {

    private String Pasaporte;
    private String Nombre;
    private int Edad;
    private Lista<Pasaje> PasajesCliente;
    
    public Cliente(){}

    public Cliente(String Pasaporte, String Nombre, int Edad) {
        this.Pasaporte = Pasaporte;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.PasajesCliente = new Lista<Pasaje>();

    }

    public Cliente(String pasaporte) {
        this.Pasaporte = pasaporte;
    }
    
    @Override
    public String toString() {
        return Pasaporte + '-' +  Nombre + '-' + Edad + '|';
    }
    
    public void setPasajesCliente(Pasaje pasaje) {
        this.PasajesCliente.agregarInicio(pasaje);
    }
    
    public void setPasajeDevuelto(Pasaje devuelto) {
        this.PasajesCliente.agregarFinal(devuelto);
    }
    
    public Lista<Pasaje> getPasajes() {
        return PasajesCliente;
    }
    
    public String getPasaporte() {
        return Pasaporte;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public int getEdad() {
        return Edad;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    
    public void setPasaporte(String pasaporte) {
        this.Pasaporte = pasaporte;
    }
    
    public void setEdad(int edad) {
        this.Edad = edad;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getPasaporte().equals(((Cliente) obj).getPasaporte());
    }

    @Override
    public int compareTo(Cliente o) {
        return this.getPasaporte().compareTo(o.getPasaporte()); // Comparar los códigos normalmente
    }

    

}
