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
public class Aerolinea {
    public String Nombre;
    public String Pais;
    public int CantMaxAviones;
    public Lista<Avion> listaAviones;
    
    public Aerolinea(String Nombre, String Pais, int CantMaxAviones) {
        this.Nombre = Nombre;
        this.Pais = Pais;
        this.CantMaxAviones = CantMaxAviones;
        this.listaAviones = new Lista();
    }
}
