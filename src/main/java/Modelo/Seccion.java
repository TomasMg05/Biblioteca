/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private String nombre;
    private List<Estanteria> estanterias;

    public Seccion(String nombre) {
        this.nombre = nombre;
        this.estanterias = new ArrayList<>();
    }

    public void agregarEstanteria(Estanteria estanteria) {
        estanterias.add(estanteria);
    }

    public void eliminarEstanteria(String codigoEstanteria) {
        estanterias.removeIf(estanteria -> estanteria.getCodigo().equals(codigoEstanteria));
    }

    public Estanteria buscarEstanteria(String codigoEstanteria) {
        for (Estanteria estanteria : estanterias) {
            if (estanteria.getCodigo().equals(codigoEstanteria)) {
                return estanteria;
            }
        }
        return null;
    }

    public List<Estanteria> getEstanterias() {
        return estanterias;
    }

    public String getNombre() {
        return nombre;
    }
}


