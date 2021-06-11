package com.mendez.windows.Administrativo.ModeloA;

import java.util.Map;

public class MensajeEnviarD extends MensajeD {
    private Map hora;

    public MensajeEnviarD() {
    }
    public MensajeEnviarD(Map hora) {
        this.hora = hora;
    }
    public MensajeEnviarD(String nombre, String urlDoc, String type_mensaje, Map hora) {
        super(nombre, urlDoc, type_mensaje);
        this.hora = hora;
    }
    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}
