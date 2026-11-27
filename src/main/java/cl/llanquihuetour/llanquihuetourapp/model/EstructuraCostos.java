package cl.llanquihuetour.llanquihuetourapp.model;

/**
 * Representa la estructura de costos de un tour, incluyendo descuento por cantidad de personas.
 */
public class EstructuraCostos {
    private int costoPersona;
    private int precioPersona;
    private int personasDescuento;
    private double porcentajeDescuento;

    public EstructuraCostos(int costoPersona, int precioPersona, int personasDescuento, double porcentajeDescuento) {

        validarDinero(costoPersona, "Costo por Persona");
        validarDinero(precioPersona, "Precio por Persona");
        validarPersonasDescuento(personasDescuento);
        validarDescuento(porcentajeDescuento);

        this.costoPersona = costoPersona;
        this.precioPersona = precioPersona;
        this.personasDescuento = personasDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getCostoPersona() {
        return costoPersona;
    }

    public int getPrecioPersona() {
        return precioPersona;
    }

    public int getPersonasDescuento() {
        return personasDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setCostoPersona(int costoPersona) {
        validarDinero(costoPersona, "Costo por Persona");
        this.costoPersona = costoPersona;
    }

    public void setPrecioPersona(int precioPersona) {
        validarDinero(precioPersona, "Precio por Persona");
        this.precioPersona = precioPersona;
    }

    public void setPersonasDescuento(int personasDescuento) {
        validarPersonasDescuento(personasDescuento);
        this.personasDescuento = personasDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        validarDescuento(porcentajeDescuento);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    private void validarDinero(int dinero, String campo) throws IllegalArgumentException {
        if (dinero < 0) {
            throw new IllegalArgumentException("El campo \"" + campo + "\" no puede ser menor a cero.");
        }
    }

    private void validarPersonasDescuento(int personasDescuento) throws IllegalArgumentException {
        if (personasDescuento < 3) {
            throw new IllegalArgumentException("No se pueden aplicar descuentos a grupos menores a tres personas");
        }
    }
    private void validarDescuento(double porcentajeDescuento) throws IllegalArgumentException {
        if (porcentajeDescuento > 0.5 || porcentajeDescuento < 0) {
            throw new IllegalArgumentException(
                    "El porcentaje de descuento debe expresarse como un decimal entre 0 y 0,5.");
        }
    }

    @Override
    public String toString() {
        return "Costo por persona: " + String.format("$%,d", costoPersona) +
                ". Precio por persona: " + String.format("$%,d", precioPersona) +
                ". Personas mínimas para descuento: " + personasDescuento +
                ". Porcentaje de descuento: " + porcentajeDescuento * 100 + "%" +
                "\n";
    }
}