/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Biblioteca;
import Modelo.Estanteria;
import Modelo.Libro;
import Modelo.Seccion;
import Vista.BibliotecaVista;

public class BibliotecaControlador {
    private Biblioteca biblioteca;
    private BibliotecaVista vista;

    public BibliotecaControlador(Biblioteca biblioteca, BibliotecaVista vista) {
        this.biblioteca = biblioteca;
        this.vista = vista;
    }

    public void agregarSeccion(String nombreSeccion) {
        Seccion seccion = new Seccion(nombreSeccion);
        biblioteca.agregarSeccion(seccion);
        vista.mostrarMensaje("Sección '" + nombreSeccion + "' agregada.");
    }

    public void eliminarSeccion(String nombreSeccion) {
        biblioteca.eliminarSeccion(nombreSeccion);
        vista.mostrarMensaje("Sección '" + nombreSeccion + "' eliminada.");
    }

    public void agregarEstanteria(String nombreSeccion, String codigoEstanteria) {
        for (Seccion seccion : biblioteca.getSecciones()) {
            if (seccion.getNombre().equals(nombreSeccion)) {
                Estanteria estanteria = new Estanteria(codigoEstanteria);
                seccion.agregarEstanteria(estanteria);
                vista.mostrarMensaje("Estantería '" + codigoEstanteria + "' agregada a la sección '" + nombreSeccion + "'.");
                return;
            }
        }
        vista.mostrarMensaje("Sección '" + nombreSeccion + "' no encontrada.");
    }

    public void eliminarEstanteria(String nombreSeccion, String codigoEstanteria) {
        for (Seccion seccion : biblioteca.getSecciones()) {
            if (seccion.getNombre().equals(nombreSeccion)) {
                seccion.eliminarEstanteria(codigoEstanteria);
                vista.mostrarMensaje("Estantería '" + codigoEstanteria + "' eliminada de la sección '" + nombreSeccion + "'.");
                return;
            }
        }
        vista.mostrarMensaje("Sección o estantería no encontrada.");
    }

    public void agregarLibro(String codigoEstanteria, Libro libro) {
        for (Seccion seccion : biblioteca.getSecciones()) {
            Estanteria estanteria = seccion.buscarEstanteria(codigoEstanteria);
            if (estanteria != null) {
                estanteria.agregarLibro(libro);
                vista.mostrarMensaje("Libro '" + libro.getTitulo() + "' agregado a la estantería '" + codigoEstanteria + "'.");
                return;
            }
        }
        vista.mostrarMensaje("Estantería '" + codigoEstanteria + "' no encontrada.");
    }

    public void moverLibro(String codigoEstanteriaOrigen, String codigoEstanteriaDestino, Libro libro) {
        Estanteria estanteriaOrigen = null;
        Estanteria estanteriaDestino = null;
        for (Seccion seccion : biblioteca.getSecciones()) {
            estanteriaOrigen = seccion.buscarEstanteria(codigoEstanteriaOrigen);
            estanteriaDestino = seccion.buscarEstanteria(codigoEstanteriaDestino);
            if (estanteriaOrigen != null && estanteriaDestino != null) {
                break;
            }
        }
        if (estanteriaOrigen != null && estanteriaDestino != null) {
            estanteriaOrigen.eliminarLibro(libro);
            estanteriaDestino.agregarLibro(libro);
            vista.mostrarMensaje("Libro '" + libro.getTitulo() + "' movido de '" + codigoEstanteriaOrigen + "' a '" + codigoEstanteriaDestino + "'.");
        } else {
            vista.mostrarMensaje("Estanterías no encontradas.");
        }
    }

    public void mostrarLibrosEnSeccion(String nombreSeccion) {
        for (Seccion seccion : biblioteca.getSecciones()) {
            if (seccion.getNombre().equals(nombreSeccion)) {
                vista.mostrarLibrosDeSeccion(seccion);
                return;
            }
        }
        vista.mostrarMensaje("Sección '" + nombreSeccion + "' no encontrada.");
    }

    public void mostrarLibrosEnEstanteria(String codigoEstanteria) {
        for (Seccion seccion : biblioteca.getSecciones()) {
            Estanteria estanteria = seccion.buscarEstanteria(codigoEstanteria);
            if (estanteria != null) {
                vista.mostrarLibrosDeEstanteria(estanteria);
                return;
            }
        }
        vista.mostrarMensaje("Estantería '" + codigoEstanteria + "' no encontrada.");
    }

    public void mostrarBiblioteca() {
        vista.mostrarBiblioteca(biblioteca);
    }
}
