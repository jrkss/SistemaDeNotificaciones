package com.mendez.windows.Administrativo.ModeloA;

public class MensajeRecibir extends Mensaje{
    private Long hora;

    public MensajeRecibir() {
    }

    public MensajeRecibir(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibir(String nombre, String mensaje, String urlFoto, String type_mensaje, Long hora) {
        super(nombre, mensaje, urlFoto, type_mensaje);
        this.hora = hora;
    }
    public MensajeRecibir(String nombre,String urlDoc, String mensaje, String urlFoto, String type_mensaje, Long hora) {
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
