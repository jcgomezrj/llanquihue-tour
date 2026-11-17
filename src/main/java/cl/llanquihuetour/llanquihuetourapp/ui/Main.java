package cl.llanquihuetour.llanquihuetourapp.ui;

import cl.llanquihuetour.llanquihuetourapp.data.GestorDatos;
import cl.llanquihuetour.llanquihuetourapp.model.Tour;

import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        final Path rutaArchivo = Path.of("src/main/resources/tours.txt");

        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours(rutaArchivo);
        for (Tour tour : tours) {
            System.out.println(tour);
        }
    }
}
