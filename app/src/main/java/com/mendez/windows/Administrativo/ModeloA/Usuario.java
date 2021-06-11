package com.mendez.windows.Administrativo.ModeloA;

public class Usuario {

    private String nombre;
    private String correo;
    private String iduser;
    private String telefono;
    private String matricula;
    private String cargo;
    private String campus;
    private String semestre;

    public Usuario() {

    }
    public Usuario(String cargo, String correo, String nombre, String campus){
        this.cargo = cargo;
        this.correo = correo;
        this.nombre = nombre;
        this.campus = campus;
    }
    public Usuario(String nombre, String correo, String iduser, String telefono, String matricula, String cargo, String campus, String semestre) {
        this.nombre = nombre;
        this.correo = correo;
        this.iduser = iduser;
        this.telefono = telefono;
        this.matricula = matricula;
        this.cargo = cargo;
        this.campus = campus;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
