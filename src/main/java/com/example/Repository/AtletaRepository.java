package com.example.Repository;

import com.example.Model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Albert on 16/01/2017.
 */
/* ---------------PER ACABAR------------------ */
@Repository
public interface AtletaRepository extends JpaRepository <Atleta,Long>{
    //Devolver todos los Atletas de una nacionalidad determinada
    List<Atleta> findByNacinalidadLike(String nacionalidad);
    //Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
    List<Atleta> findByFecha_nacimientoLessThan(Date fecha_nacimiento);
    //Devolver todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>
    List<Atleta> findByNacionalidadIs();

}
