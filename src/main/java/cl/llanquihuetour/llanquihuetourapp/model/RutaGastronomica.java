package cl.llanquihuetour.llanquihuetourapp.model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        validarNumeroDeParadas(numeroDeParadas);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        validarNumeroDeParadas(numeroDeParadas);
        this.numeroDeParadas = numeroDeParadas;
    }

    private void validarNumeroDeParadas(int numeroDeParadas)  throws IllegalArgumentException {
        if  (numeroDeParadas <= 0) {
            throw new IllegalArgumentException("El número de paradas debe ser mayor que cero.");
        }
    }

    @Override
    public String toString() {
        return "** Ruta Gastronómica: **\n" +
                "Nombre: " + super.getNombre() + "\n" +
                "Duración en horas: " + super.getDuracionHoras() + "\n" +
                "Numero de paradas: " + numeroDeParadas + "\n";
    }
}
