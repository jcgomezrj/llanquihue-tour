package cl.llanquihuetour.llanquihuetourapp.model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        validarLugarHistorico(lugarHistorico);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        validarLugarHistorico(lugarHistorico);
        this.lugarHistorico = lugarHistorico;
    }

    private void validarLugarHistorico(String lugarHistorico) throws IllegalArgumentException {
        if (lugarHistorico == null || lugarHistorico.isBlank()) {
            throw new IllegalArgumentException("El Lugar Histórico no puede ser nulo o estar vacío.");
        }
    }

    @Override
    public String toString() {
        return "** Excursión Cultural: **\n" +
                "Nombre: " + super.getNombre() + "\n" +
                "Duración en horas: " + super.getDuracionHoras() + "\n" +
                "Lugar Histórico: " + lugarHistorico + "\n";
    }
}