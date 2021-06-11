package com.mendez.windows.Administrativo.ModeloA;

public class MensajeRecibirD extends MensajeD {
    private Long hora;

    public MensajeRecibirD() {
    }

    public MensajeRecibirD(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibirD(String nombre, String urlDoc, String type_mensaje, Long hora) {
        super(nombre, urlDoc, type_mensaje);
        this.hora = hora;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}
