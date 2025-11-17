package vaga_junior.vaga_junior.controllers;

import vaga_junior.vaga_junior.data.dto.BombaCombustivelDTO;
import vaga_junior.vaga_junior.model.BombaCombustivel;
import vaga_junior.vaga_junior.services.BombaCombustivelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bombascombustivel")

public class BombaCombustivelController {

    @Autowired
    private BombaCombustivelServices service;

    // Acessa o método findAll() do BombaCombustivelService
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BombaCombustivelDTO> findAll() {
        return service.findAll();
    }

    // Acessa o método findById() do BombaCombustivelService
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BombaCombustivelDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // Acessa o método create() do BombaCombustivelService
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BombaCombustivelDTO create(@RequestBody BombaCombustivelDTO bombaCombustivelDTO) {
        return service.create(bombaCombustivelDTO);
    }

    // Acessa o método update() do BombaCombustivelService
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BombaCombustivelDTO update(@RequestBody BombaCombustivelDTO bombaCombustivelDTO) {
        return service.update(bombaCombustivelDTO);
    }

    // Acessa o método delete() do BombaCombustivelService
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
