package com.mendez.windows.Administrativo.ModeloA;

public class MensajeD {
   private String mensaje;
    private String urlDoc;
    private String nombre;
    private String type_mensaje;

    public MensajeD() {
    }
    public MensajeD(String nombre, String urlDoc, String type_mensaje) {

        this.urlDoc = urlDoc;
        this.nombre = nombre;
        this.type_mensaje = type_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrlDoc() {
        return urlDoc;
    }

    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getType_mensaje() {
        return type_mensaje;
    }

    public void setType_mensaje(String type_mensaje) {
        this.type_mensaje = type_mensaje;
    }
}
