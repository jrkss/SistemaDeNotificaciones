package com.mendez.windows.Administrativo.ModeloA;

public class Mensaje {
    private String mensaje;
    private String urlFoto;
    private String nombre;
    private String urlDoc;
    private String type_mensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String nombre, String type_mensaje) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.type_mensaje = type_mensaje;
    }
    public Mensaje(String mensaje, String urlFoto, String nombre, String type_mensaje) {
        this.mensaje = mensaje;
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.type_mensaje = type_mensaje;
    }
    public Mensaje(String mensaje,String urlDoc, String urlFoto, String nombre, String type_mensaje){
        this.mensaje = mensaje;
        this.urlDoc = urlDoc;
        this.urlFoto = urlFoto;
        this.nombre = nombre;
        this.type_mensaje = type_mensaje;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlDoc() {
        return urlDoc;
    }

    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }


}
