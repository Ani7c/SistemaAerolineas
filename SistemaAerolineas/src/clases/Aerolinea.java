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
public class Aerolinea implements Comparable<Aerolinea>{
    private String Nombre;
    private String Pais;
    private int CantMaxAviones;
    private Lista<Avion> listaAviones;
    
    public Aerolinea(){};
    
    public Aerolinea(String Nombre, String Pais, int CantMaxAviones) {
        this.Nombre = Nombre;
        this.Pais = Pais;
        this.CantMaxAviones = CantMaxAviones;
        this.listaAviones = new Lista<Avion>();
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public String getPais() {
        return Pais;
    }
    
    public int getCantMaxAviones() {
        return CantMaxAviones;
    }
    
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    
    public void setPais(String pais) {
        this.Pais = pais;
    }
    
    public void setCantMaxAviones(int cantMaxAviones) {
        this.CantMaxAviones = cantMaxAviones;
    }
    
    public Lista<Avion> getAviones() {
        return listaAviones;
    }
    
    public void setAviones(Avion avion) {
        this.listaAviones.agregarInicio(avion);
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getNombre().equals(((Aerolinea) obj).getNombre());
    }

    @Override
    public int compareTo(Aerolinea o) {
        //return this.getNombre().compareTo(o.getNombre());    
          if (this.getNombre() == null && o.getNombre() == null) {
        return 0; // Ambos códigos son null, por lo que son iguales
    } else if (this.getNombre() == null) {
        return -1; // El código de este avión es null, por lo que es menor que el otro
    } else if (o.getNombre() == null) {
        return 1; // El código del otro avión es null, por lo que este es mayor que el otro
    } else {
        return this.getNombre().compareTo(o.getNombre()); // Comparar los códigos normalmente
    }
    }
    
    @Override
    public String toString() {
        return this.getNombre() +"-"+ this.getPais() +"-"+ this.getCantMaxAviones() +"|";
    }
}
