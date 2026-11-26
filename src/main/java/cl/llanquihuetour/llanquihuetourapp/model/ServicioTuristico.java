package cl.llanquihuetour.llanquihuetourapp.model;

/**
 * Representa un servicio turístico genérico.
 */
public class ServicioTuristico {
    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {

        validarNombre(nombre);
        validarDuracionHoras(duracionHoras);

        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public void setDuracionHoras(int duracionHoras) {
        validarDuracionHoras(duracionHoras);
        this.duracionHoras = duracionHoras;
    }

    private void validarNombre(String nombre) throws IllegalArgumentException {
        if (nombre == null ||  nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni estar vacío.");
        }
    }
    private void validarDuracionHoras(int duracionHoras) throws IllegalArgumentException {
        if (duracionHoras <= 0) {
            throw new IllegalArgumentException("La duración en horas debe ser mayor que cero.");
        }
    }

    @Override
    public String toString() {
        return "** ServicioTuristico: **\n" +
                "Nombre: " + nombre + "\n" +
                "Duración en horas: " + duracionHoras + "\n";
    }
}