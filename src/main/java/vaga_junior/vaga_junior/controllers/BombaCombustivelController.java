package vaga_junior.vaga_junior.controllers;

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

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BombaCombustivel> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<BombaCombustivel> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BombaCombustivel create(@RequestBody BombaCombustivel bombaCombustivel) {
        return service.create(bombaCombustivel);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BombaCombustivel update(@RequestBody BombaCombustivel bombaCombustivel) {
        return service.update(bombaCombustivel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
