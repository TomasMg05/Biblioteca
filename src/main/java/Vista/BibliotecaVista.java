/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Autor;
import Modelo.Biblioteca;
import Modelo.Estanteria;
import Modelo.Libro;
import Modelo.Seccion;

public class BibliotecaVista {

    public void mostrarBiblioteca(Biblioteca biblioteca) {
        System.out.println("Biblioteca: " + biblioteca.getNombre());
        for (Seccion seccion : biblioteca.getSecciones()) {
            System.out.println("- Sección: " + seccion.getNombre());
            for (Estanteria estanteria : seccion.getEstanterias()) {
                System.out.println("-- Estantería: " + estanteria.getCodigo());
                for (Libro libro : estanteria.getLibros()) {
                    System.out.println("--- Libro: " + libro.getTitulo());
                    System.out.print("---- Autores: ");
                    for (Autor autor : libro.getAutores()) {
                        System.out.print(autor.getNombre() + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public void mostrarLibrosDeSeccion(Seccion seccion) {
        System.out.println("Libros en la sección '" + seccion.getNombre() + "':");
        for (Estanteria estanteria : seccion.getEstanterias()) {
            for (Libro libro : estanteria.getLibros()) {
                System.out.println("- Libro: " + libro.getTitulo());
            }
        }
    }

    public void mostrarLibrosDeEstanteria(Estanteria estanteria) {
        System.out.println("Libros en la estantería '" + estanteria.getCodigo() + "':");
        for (Libro libro : estanteria.getLibros()) {
            System.out.println("- Libro: " + libro.getTitulo());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
