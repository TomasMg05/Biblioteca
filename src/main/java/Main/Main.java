/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controlador.BibliotecaControlador;
import Modelo.Autor;
import Modelo.Biblioteca;
import Modelo.Libro;
import Vista.BibliotecaVista;

public class Main {
    public static void main(String[] args) {
        // Crear modelo: la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // Crear la vista
        BibliotecaVista vista = new BibliotecaVista();

        // Crear el controlador
        BibliotecaControlador controlador = new BibliotecaControlador(biblioteca, vista);

        // Agregar secciones
        controlador.agregarSeccion("Ficción");
        controlador.agregarSeccion("Ciencia");

        // Agregar estanterías
        controlador.agregarEstanteria("Ficción", "Estantería 1");
        controlador.agregarEstanteria("Ciencia", "Estantería 2");

        // Crear libros
        Libro libro1 = new Libro("El Señor de los Anillos");
        libro1.agregarAutor(new Autor("J.R.R. Tolkien"));

        Libro libro2 = new Libro("Breve historia del tiempo");
        libro2.agregarAutor(new Autor("Stephen Hawking"));

        Libro libro3 = new Libro("Cien años de soledad");
        libro3.agregarAutor(new Autor("Gabriel García Márquez"));

        // Agregar libros a estanterías
        controlador.agregarLibro("Estantería 1", libro1);
        controlador.agregarLibro("Estantería 2", libro2);

        // Mover libro de una estantería a otra
        controlador.moverLibro("Estantería 1", "Estantería 2", libro1);

        // Listar libros de una sección específica
        controlador.mostrarLibrosEnSeccion("Ciencia");

        // Listar libros de una estantería específica
        controlador.mostrarLibrosEnEstanteria("Estantería 2");

        // Eliminar una estantería
        controlador.eliminarEstanteria("Ciencia", "Estantería 2");

        // Eliminar una sección completa
        controlador.eliminarSeccion("Ficción");

        // Mostrar toda la biblioteca actualizada
        controlador.mostrarBiblioteca();
    }
}
