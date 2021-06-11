package com.mendez.windows.Alumno.ModeloA;

public class MensajeRecibirA extends MensajeA {
    private Long hora;

    public MensajeRecibirA() {
    }

    public MensajeRecibirA(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibirA(String nombre, String mensaje, String urlFoto, String type_mensaje, Long hora) {
        super(nombre, mensaje, urlFoto, type_mensaje);
        this.hora = hora;
    }
    public MensajeRecibirA(String nombre,String urlDoc, String mensaje, String urlFoto, String type_mensaje, Long hora) {
        super(nombre, urlDoc, mensaje, urlFoto, type_mensaje);
        this.hora = hora;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}
