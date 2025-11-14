package vaga_junior.vaga_junior.controllers;

import vaga_junior.vaga_junior.model.Abastecimento;
import vaga_junior.vaga_junior.services.AbastecimentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoServices service;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Abastecimento> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Optional<Abastecimento> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Abastecimento create(@RequestBody Abastecimento abastecimento) {
        return service.create(abastecimento);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Abastecimento update(@RequestBody Abastecimento abastecimento) {
        return service.update(abastecimento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    } 
}