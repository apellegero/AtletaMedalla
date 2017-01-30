package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Albert on 21/12/2016.
 */
@Entity
public class Atleta {
    //Un atleta tendrá los siguiente atributos: Id, Nombre, Apellidos, nacionalidad, Fecha nacimiento.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public long id;

    @Column
    public String nombre;

    @Column
    public String apellido;

    @Column
    public String nacionalidad;

    @Column
    public Date fecha_nacimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL)
    private Set<Medalla> medallas = new HashSet<>();

    public Atleta(){}

    public Atleta(String nombre, String apellido, String nacionalidad, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Set<Medalla> getMedallas() {
        return medallas;
    }

    public void setMedallas(Set<Medalla> medallas) {
        this.medallas = medallas;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", medallas=" + medallas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atleta)) return false;

        Atleta atleta = (Atleta) o;

        if (id != atleta.id) return false;
        if (nombre != null ? !nombre.equals(atleta.nombre) : atleta.nombre != null) return false;
        if (apellido != null ? !apellido.equals(atleta.apellido) : atleta.apellido != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(atleta.nacionalidad) : atleta.nacionalidad != null)
            return false;
        if (fecha_nacimiento != null ? !fecha_nacimiento.equals(atleta.fecha_nacimiento) : atleta.fecha_nacimiento != null)
            return false;
        return medallas != null ? medallas.equals(atleta.medallas) : atleta.medallas == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (fecha_nacimiento != null ? fecha_nacimiento.hashCode() : 0);
        result = 31 * result + (medallas != null ? medallas.hashCode() : 0);
        return result;
    }
}
