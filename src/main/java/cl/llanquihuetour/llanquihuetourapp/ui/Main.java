package cl.llanquihuetour.llanquihuetourapp.ui;

import cl.llanquihuetour.llanquihuetourapp.data.GestorDatos;
import cl.llanquihuetour.llanquihuetourapp.model.Tour;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        final Path rutaArchivo = Path.of("src/main/resources/tours.txt");
        GestorDatos gestor = new GestorDatos();

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
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el archivo " + rutaArchivo.toAbsolutePath());
        }
    }
}