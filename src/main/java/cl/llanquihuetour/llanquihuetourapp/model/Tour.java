package cl.llanquihuetour.llanquihuetourapp.model;

import java.time.LocalDate;

/**
 * Esta clase representa un tour, incluye información identificatoria y también estructura de costos.
 */
public class Tour {
    private String nombreTour;
    private String codigoIdentificador;
    private String paisDestino;
    private EstructuraCostos estructuraCostos;
    private String medioTransporte;
    private LocalDate fechaCreacion;

    public Tour(
            String nombreTour,
            String codigoIdentificador,
            String paisDestino,
            EstructuraCostos estructuraCostos,
            String medioTransporte,
            LocalDate fechaCreacion) {

        validarNoVacioNulo(nombreTour, "Nombre del Tour");
        validarNoVacioNulo(codigoIdentificador, "Código Identificador");
        validarNoVacioNulo(paisDestino, "País de Destino");
        validarNoNulo(estructuraCostos, "Estructura de Costos");
        validarNoVacioNulo(medioTransporte, "Medio de Transporte");
        validarFechaCreacion(fechaCreacion, "Fecha de Creación");

        this.nombreTour = nombreTour;
        this.codigoIdentificador = codigoIdentificador;
        this.paisDestino = paisDestino;
        this.estructuraCostos = estructuraCostos;
        this.medioTransporte = medioTransporte;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreTour() {
        return nombreTour;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public EstructuraCostos getEstructuraCostos() {
        return estructuraCostos;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setNombreTour(String nombreTour) {
        validarNoVacioNulo(nombreTour, "Nombre del Tour");
        this.nombreTour = nombreTour;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        validarNoVacioNulo(codigoIdentificador, "Código Identificador");
        this.codigoIdentificador = codigoIdentificador;
    }

    public void setPaisDestino(String paisDestino) {
        validarNoVacioNulo(paisDestino, "País de Destino");
        this.paisDestino = paisDestino;
    }

    public void setEstructuraCostos(EstructuraCostos estructuraCostos) {
        validarNoNulo(estructuraCostos, "Estructura de Costos");
        this.estructuraCostos = estructuraCostos;
    }

    public void setMedioTransporte(String medioTransporte) {
        validarNoVacioNulo(medioTransporte, "Medio de Transporte");
        this.medioTransporte = medioTransporte;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        validarFechaCreacion(fechaCreacion, "Fecha de Creación");
        this.fechaCreacion = fechaCreacion;
    }

    private void validarNoVacioNulo(String campo, String nombreCampo) throws IllegalArgumentException {
        if (campo == null || campo.isEmpty()) {
            throw new IllegalArgumentException("El campo \"" + nombreCampo + "\" no puede estar vacío.");
        }
    }

    private void validarNoNulo(Object campo, String nombreCampo) throws IllegalArgumentException {
        if (campo == null) {
            throw new IllegalArgumentException("El campo \"" + nombreCampo + "\" no puede ser nulo.");
        }
    }

    private void validarFechaCreacion(LocalDate fechaCreacion, String campo) {
        LocalDate hoy =  LocalDate.now();
        if (fechaCreacion.isAfter(hoy)) {
            throw new IllegalArgumentException("La fecha de creación no puede ser posterior al día de hoy.");
        }
    }

    @Override
    public String toString() {
        return "Tours{" +
                "nombreTour='" + nombreTour + '\'' +
                ", codigoIdentificador='" + codigoIdentificador + '\'' +
                ", paisDestino='" + paisDestino + '\'' +
                ", estructuraCostos=" + estructuraCostos +
                ", medioTransporte='" + medioTransporte + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
