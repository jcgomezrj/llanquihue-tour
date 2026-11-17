package cl.llanquihuetour.llanquihuetourapp.data;

import cl.llanquihuetour.llanquihuetourapp.model.EstructuraCostos;
import cl.llanquihuetour.llanquihuetourapp.model.Tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;


public class GestorDatos {

    public ArrayList<Tour> cargarTours(Path rutaArchivo) {
        ArrayList<Tour> tours = new ArrayList<>();
        String linea = "";
        int numeroLinea = 0;
        int costoPersona = 0;
        int precioPersona = 0;
        int personasDescuento = 0;
        double porcentajeDescuento = 0;
        int year = 0;
        int month = 0;
        int day = 0;

        try (BufferedReader lector = Files.newBufferedReader(rutaArchivo, StandardCharsets.UTF_8)) {
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                // Omitir líneas vacías
                if (linea.isEmpty()) {
                    System.err.println("Línea número " + numeroLinea + " está vacía y fue omitida.");
                    continue;
                }
                String[] campos = linea.split(";", -1);

                // Omitir líneas con un número incorrecto de campos.
                if (campos.length != 11) {
                    System.err.println(
                            "Línea número " + numeroLinea + " no contiene los campos esperados y fue omitida.");
                }

                // Eliminar espacios de los campos.
                for (String campo : campos) {
                    campo = campo.trim();
                }

                // Parsear los campos numéricos, omitir línea en caso de falla.
                try {
                    costoPersona = Integer.parseInt(campos[3]);
                    precioPersona = Integer.parseInt(campos[4]);
                    personasDescuento = Integer.parseInt(campos[5]);
                    porcentajeDescuento = Double.parseDouble(campos[6]);
                    year = Integer.parseInt(campos[8]);
                    month = Integer.parseInt(campos[9]);
                    day = Integer.parseInt(campos[10]);
                } catch (NumberFormatException e) {
                    System.err.println(
                            "Uno de los campos numéricos de la línea " + numeroLinea + "no tiene un formato válido.");
                    continue;
                }

                // Construir objetos y agregar a lista.
                try {
                    EstructuraCostos estructuraCostos = new EstructuraCostos(
                            costoPersona,
                            precioPersona,
                            personasDescuento,
                            porcentajeDescuento);
                    LocalDate fechaInicio = LocalDate.of(year, month, day);
                    Tour tour = new Tour(
                            campos[0],
                            campos[1],
                            campos[3],
                            estructuraCostos,
                            campos[7],
                            fechaInicio);
                    tours.add(tour);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error al crear los objetos: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al intentar abrir el archivo " + rutaArchivo.toAbsolutePath() + ".");
        }
        return tours;
    }
}