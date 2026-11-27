package cl.llanquihuetour.llanquihuetourapp.ui;

import cl.llanquihuetour.llanquihuetourapp.data.GestorDatos;
import cl.llanquihuetour.llanquihuetourapp.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Path rutaArchivo = Path.of("src/main/resources/tours.txt");
        GestorDatos gestor = new GestorDatos();
        Scanner sc = new Scanner(System.in);
        String entrada = "";

        try {

            // Cargar lista usando método.
            ArrayList<Tour> tours = gestor.cargarTours(rutaArchivo);

            // Imprimir todos los registros.
            System.out.println("Mostrando todos los tours:\n");
            for (Tour tour : tours) {
                System.out.println("********** Tour **********\n");
                System.out.println(tour);
            }

            System.out.println("\n\n--------------------------------\n\n");

            // Imprimir registros filtrados.
            System.out.println("Mostrando solo tours con destino Brasil:\n\n");
            for (Tour tour : tours) {
                if (tour.getPaisDestino().equalsIgnoreCase("Brasil")) {
                    System.out.println("********** Tour **********\n");
                    System.out.println(tour);
                }
            }

            // Preguntar por términos de búsqueda
            while (true) {
                System.out.println(
                        "Ingrese un término para buscar por ciudad o país de destino. Para terminar, escriba \"salir\".");
                entrada = sc.nextLine();
                if (entrada == null || entrada.isBlank()) {
                    continue;
                }

                // Estandarizar la entrada para comparaciones.
                entrada = entrada.trim().toLowerCase();

                // Salir del while en caso de "salir".
                if (entrada.equals("salir")) {
                    break;
                }

                int encontrados = 0;
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
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el archivo " + rutaArchivo.toAbsolutePath());
        }

        gestor.demostracionObjetos();

        // todo falta ordenar y ver qué partes van y cuáles no.

        // Cerrar scanner
        sc.close();
    }
}