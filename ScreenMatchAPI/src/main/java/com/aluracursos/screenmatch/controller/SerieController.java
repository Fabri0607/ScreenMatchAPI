package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping()
    public List<SerieDTO> getSeries(){
        return service.getSeries();
    }

    @GetMapping("top5")
    public List<SerieDTO> getTop5Series(){
        return service.getTop5Series();
    }

    @GetMapping("lanzamientos")
    public List<SerieDTO> getLanzamientosRecientes(){
        return service.getLanzamientosRecientes();
    }

    @GetMapping("/{id}")
    public SerieDTO getSerieById(@PathVariable Long id){
        return service.getSerieById(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> getEpisodios(@PathVariable Long id){
        return service.getEpisodios(id);
    }

    @GetMapping("/{id}/temporadas/{temporada}")
    public List<EpisodioDTO> getEpisodiosT(@PathVariable Long id, @PathVariable int temporada){
        return service.getEpisodiosT(id, temporada);
    }

    @GetMapping("/categoria/{nombreGenero}")
    public List<SerieDTO> getSeriesPorCategoria(@PathVariable String nombreGenero){
        return service.getSeriesPorCategoria(nombreGenero);
    }

}
