package cl.llanquihuetour.llanquihuetourapp.model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        validarTipoEmbarcacion(tipoEmbarcacion);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        validarTipoEmbarcacion(tipoEmbarcacion);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    private void validarTipoEmbarcacion(String tipoEmbarcacion) throws IllegalArgumentException {
        String[] embarcaciones = {"lancha", "velero", "catamarán", "catamaran", "bote"};
        boolean esValido = false;
        for (String embarcacion : embarcaciones) {
            if (embarcacion.trim().equals(tipoEmbarcacion)) {
                esValido = true;
            }
        }
        if (!esValido) {
            throw new IllegalArgumentException("El Tipo de Embarcación no es válido,");
        }
    }

    @Override
    public String toString() {
        return "** Paseo Lacustre: **\n" +
                "Nombre: " + super.getNombre() + "\n" +
                "Duración en horas: " + super.getDuracionHoras() + "\n" +
                "Tipo de Embarcación: " + tipoEmbarcacion + "\n";
    }
}