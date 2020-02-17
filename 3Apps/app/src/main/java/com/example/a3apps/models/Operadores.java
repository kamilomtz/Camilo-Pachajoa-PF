package com.example.a3apps.models;

public class Operadores {


    private String nombre_del_operador;
    private String prestador_del_servicio_turistico;
    private String direcci_n;
    private String telefono;
    private String correo_electronico;
    private String servicio_que_presta;

    public String getNombre_del_operador() {
        return nombre_del_operador;
    }

    public void setNombre_del_operador(String nombre_del_operador) {
        this.nombre_del_operador = nombre_del_operador;
    }

    public String getPrestador_del_servicio_turistico() {
        return prestador_del_servicio_turistico;
    }

    public void setPrestador_del_servicio_turistico(String prestador_del_servicio_turistico) {
        this.prestador_del_servicio_turistico = prestador_del_servicio_turistico;
    }

    public String getDirecci_n() {
        return direcci_n;
    }

    public void setDirecci_n(String direcci_n) {
        this.direcci_n = direcci_n;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getServicio_que_presta() {
        return servicio_que_presta;
    }

    public void setServicio_que_presta(String servicio_que_presta) {
        this.servicio_que_presta = servicio_que_presta;
    }
}