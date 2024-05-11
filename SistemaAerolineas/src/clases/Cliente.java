/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author anita
 */
public class Cliente {

    private String Pasaporte;
    private String Nombre;
    private int Edad;
    
    public Cliente(){}

    public Cliente(String Pasaporte, String Nombre, int Edad) {
        this.Pasaporte = Pasaporte;
        this.Nombre = Nombre;
        this.Edad = Edad;
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
}
