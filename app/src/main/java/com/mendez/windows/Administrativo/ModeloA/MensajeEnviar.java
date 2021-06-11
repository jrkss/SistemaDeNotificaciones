package com.mendez.windows.Administrativo.ModeloA;

import java.util.Map;

public class MensajeEnviar extends Mensaje {
    private Map hora;

    public MensajeEnviar() {
    }
    public MensajeEnviar(Map hora) {
        this.hora = hora;
    }

    public MensajeEnviar(String nombre, String mensaje, String type_mensaje, Map hora) {
        super(nombre, mensaje, type_mensaje);
        this.hora = hora;
    }

    public MensajeEnviar(String nombre, String mensaje, String urlFoto, String type_mensaje, Map hora) {
        super(nombre, mensaje, urlFoto, type_mensaje);
        this.hora = hora;
    }
    public MensajeEnviar(String nombre,String urlDoc, String mensaje, String urlFoto, String type_mensaje, Map hora) {
        super(nombre,urlDoc, mensaje, urlFoto, type_mensaje);
        this.hora = hora;
    }


    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}
