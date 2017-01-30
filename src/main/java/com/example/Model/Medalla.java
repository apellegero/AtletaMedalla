package com.example.Model;

import javax.persistence.*;

/**
 * Created by Albert on 21/12/2016.
 */
@Entity
public class Medalla {
    //Las medallas tendrán los siguientes atributos: Id, Enumeración (Oro, Plata, Bronce), Especialidad, Competición.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    @Enumerated(EnumType.STRING)
    private CategoriaMedalla categoriaMedalla;

    @Column
    private String especialitat;

    @Column
    private String competicio;

    @ManyToOne
    private Atleta atleta;

    public Medalla(){}

    public Medalla(CategoriaMedalla categoriaMedalla, String especialitat, String competicio, Atleta atleta) {
        this.categoriaMedalla = categoriaMedalla;
        this.especialitat = especialitat;
        this.competicio = competicio;
        this.atleta = atleta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoriaMedalla getCategoriaMedalla() {
        return categoriaMedalla;
    }

    public void setCategoriaMedalla(CategoriaMedalla categoriaMedalla) {
        this.categoriaMedalla = categoriaMedalla;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", categoriaMedalla=" + categoriaMedalla +
                ", especialitat='" + especialitat + '\'' +
                ", competicio='" + competicio + '\'' +
                ", atleta=" + atleta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medalla)) return false;

        Medalla medalla = (Medalla) o;

        if (id != medalla.id) return false;
        if (categoriaMedalla != medalla.categoriaMedalla) return false;
        if (especialitat != null ? !especialitat.equals(medalla.especialitat) : medalla.especialitat != null)
            return false;
        if (competicio != null ? !competicio.equals(medalla.competicio) : medalla.competicio != null) return false;
        return atleta != null ? atleta.equals(medalla.atleta) : medalla.atleta == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (categoriaMedalla != null ? categoriaMedalla.hashCode() : 0);
        result = 31 * result + (especialitat != null ? especialitat.hashCode() : 0);
        result = 31 * result + (competicio != null ? competicio.hashCode() : 0);
        result = 31 * result + (atleta != null ? atleta.hashCode() : 0);
        return result;
    }
}
