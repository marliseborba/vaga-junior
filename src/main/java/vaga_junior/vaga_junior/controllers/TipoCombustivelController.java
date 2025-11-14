package vaga_junior.vaga_junior.controllers;

import vaga_junior.vaga_junior.model.TipoCombustivel;
import vaga_junior.vaga_junior.services.TipoCombustivelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tiposcombustivel")

public class TipoCombustivelController {

    @Autowired
    private TipoCombustivelServices service;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoCombustivel> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<TipoCombustivel> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TipoCombustivel create(@RequestBody TipoCombustivel tipoCombustivel) {
        return service.create(tipoCombustivel);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TipoCombustivel update(@RequestBody TipoCombustivel tipoCombustivel) {
        return service.update(tipoCombustivel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
