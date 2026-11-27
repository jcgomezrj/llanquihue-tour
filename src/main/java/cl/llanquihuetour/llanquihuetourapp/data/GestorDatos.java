package cl.llanquihuetour.llanquihuetourapp.data;

import cl.llanquihuetour.llanquihuetourapp.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Gestiona la interacción del programa con datos externos, además de crear objetos de muestra.
 */
public class GestorDatos {

    /**
     * Carga datos desde un archivo de texto separado por punto y coma.
     * @param rutaArchivo Objeto Path con la ruta del archivo.
     * @return Lista con los objetos Tour leídos.
     * @throws IOException
     */
    public ArrayList<Tour> cargarTours(Path rutaArchivo) throws IOException {
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
                            "Uno de los campos numéricos de la línea " + numeroLinea + " no tiene un formato válido.");
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
                            campos[2],
                            estructuraCostos,
                            campos[7],
                            fechaInicio);
                    tours.add(tour);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error al crear los objetos: " + e.getMessage());
                }
            }
        }
        return tours;
    }

    /**
     * Crea objetos de prueba de subclases y los muestra por pantalla usando toString().
     */
    public void demostracionObjetos() throws IllegalArgumentException {

        PaseoLacustre paseoLacustre1 = new PaseoLacustre(
                "Lago Ranco",
                5,
                "velero");
        PaseoLacustre paseoLacustre2 = new PaseoLacustre(
                "Lago de Todos Los Santos",
                4,
                "catamarán");
        ExcursionCultural excursionCultural1 = new ExcursionCultural(
                "Centro Histórico de Santiago",
                5,
                "Palacio de La Moneda");
        ExcursionCultural excursionCultural2 = new ExcursionCultural(
                "Puerto de Valparaíso",
                7,
                "Batería Esmeralda");
        RutaGastronomica rutaGastronomica1 = new RutaGastronomica(
                "La Ruta del Sushi",
                5,
                3);
        RutaGastronomica rutaGastronomica2 = new RutaGastronomica(
                "La Ruta de la Hamburguesa",
                4,
                3);
        System.out.println(paseoLacustre1.toString());
        System.out.println(paseoLacustre2.toString());
        System.out.println(rutaGastronomica1.toString());
        System.out.println(rutaGastronomica2.toString());
        System.out.println(paseoLacustre1.toString());
        System.out.println(paseoLacustre2.toString());
    }

}