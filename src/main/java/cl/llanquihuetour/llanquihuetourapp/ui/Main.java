package cl.llanquihuetour.llanquihuetourapp.ui;

import cl.llanquihuetour.llanquihuetourapp.data.GestorDatos;
import cl.llanquihuetour.llanquihuetourapp.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaraciones globales.
        GestorDatos gestor = new GestorDatos();
        Scanner sc = new Scanner(System.in);
        String entrada = "";
        int encontrados = 0;
        List<Tour> tours = new ArrayList<>();

        // Cargar lista desde el gestor de datos.
        final Path rutaArchivo = Path.of("src/main/resources/tours.txt");
        try {
            tours = gestor.cargarTours(rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el archivo " + rutaArchivo.toAbsolutePath());
        }

        // Interacción con el usuario.
        System.out.println("\n***** Bienvenidos/as a Llanquihue Tour App. ¿Qué deseas hacer hoy? *****\n");
        while (true) {
            System.out.println("1- Para ver nuestras nuevas opciones de Servicios Turísticos, escribe \"servicios\".");
            System.out.println("2- Para buscar un tour por ciudad o país de destino, ingresa un término de búsqueda.");
            System.out.println("3- Para ver todos los tours, ingresa \"todos\".");
            System.out.println("4- Para salir del programa, escribe \"salir\".\n");
            entrada = sc.nextLine();
            if (entrada == null || entrada.isBlank()) {
                continue;
            }

            // Estandarizar la entrada para comparaciones.
            entrada = entrada.trim().toLowerCase();

            // Mostrar Servicios Turísticos.
            if (entrada.equals("servicios")) {
                gestor.demostracionObjetos();
                continue;
            }

            // Salir del while en caso de "salir".
            if (entrada.equals("salir")) {
                break;
            }

            // Mostrar todos los tours.
            if (entrada.equals("todos")) {
                encontrados = 0;
                System.out.println("Mostrando todos los tours:\n");
                for (Tour tour : tours) {
                    encontrados++;
                    System.out.println("********** Tour N° " + encontrados + " **********\n");
                    System.out.println(tour);
                }
                continue;
            }

            // Búsqueda de tours por palabras clave.
            encontrados = 0;
            for (Tour tour : tours) {
                if (tour.getPaisDestino().toLowerCase().contains(entrada) || tour.getNombreTour().toLowerCase().contains(entrada)) {
                    encontrados++;
                    System.out.println("********** Tour encontrado número " + encontrados + " **********");
                    System.out.println(tour);
                }
            }
            if (encontrados == 0) {
                System.out.println("No se encontró ningún tour con ese término de búsqueda.\n");
            }
        }




        //











        // Cerrar scanner
        sc.close();
    }
}