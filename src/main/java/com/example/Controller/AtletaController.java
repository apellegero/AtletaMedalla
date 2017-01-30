package com.example.Controller;

import com.example.Model.Atleta;
import com.example.Model.CategoriaMedalla;
import com.example.Repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Albert on 18/01/2017.
 */
@RestController
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta crearAtleta(@RequestBody Atleta atleta){
        return (Atleta) atletaRepository.save(atleta);
    }

    @GetMapping
    public List<Atleta> GetAllAtletas(){
        return atletaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteAtletaId(@PathVariable Long id){
        Atleta atleta = (Atleta) atletaRepository.findOne(id);
        if(atleta != null) atletaRepository.delete(id);
    }

    //1 Devolver todos los Atletas de una nacionalidad determinada
    @GetMapping("/nacionalidadLike/{nacionalidad}")
    public List <Atleta> findByNacinalidadLike(@PathVariable String nacionalidad){
        return atletaRepository.findByNacinalidadLike(nacionalidad);
    }

    //2 Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada
    @GetMapping("/fechaNacimientoLessThan/{fechaNacimiento}")
    public List<Atleta> findByFecha_nacimientoLessThan(@PathVariable Date fechaNacimiento){
        return atletaRepository.findByFecha_nacimientoLessThan(fechaNacimiento);
    }

    //3 Devolver todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>
    @GetMapping("/ordenarPerNacionalidad")
    public Map<String, List<Atleta>> findByNacionalidadIs(){
        return (Map<String, List<Atleta>>) atletaRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Atleta::getNacionalidad));
    }

    //4 Devolver todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List <Atleta>>
    @GetMapping("/groupByCategoriaMedalla")
    public Map<CategoriaMedalla, List<Atleta>> getAtletaGroupByCategoriaMedalla(){
        return atletaRepository.findAll().parallelStream().collect(groupingBy(atleta->{
            if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getCategoriaMedalla() == CategoriaMedalla.OR)){
                return CategoriaMedalla.OR;
            }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getCategoriaMedalla() == CategoriaMedalla.PLATA)){
                return CategoriaMedalla.PLATA;
            }else if(atleta.getMedallas().stream().anyMatch(medalla -> medalla.getCategoriaMedalla() == CategoriaMedalla.BRONZA)){
                return CategoriaMedalla.BRONZA;
            }else {
                return CategoriaMedalla.NONE;
            }
        }));
    }
}
