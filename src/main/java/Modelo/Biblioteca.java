/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Seccion> secciones;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.secciones = new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion) {
        secciones.add(seccion);
    }

    public void eliminarSeccion(String nombreSeccion) {
        secciones.removeIf(seccion -> seccion.getNombre().equals(nombreSeccion));
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public String getNombre() {
        return nombre;
    }
}

