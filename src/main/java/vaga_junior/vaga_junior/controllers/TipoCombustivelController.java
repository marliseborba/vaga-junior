package vaga_junior.vaga_junior.controllers;

import vaga_junior.vaga_junior.data.dto.TipoCombustivelDTO;
import vaga_junior.vaga_junior.services.TipoCombustivelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposcombustivel")

public class TipoCombustivelController {

    @Autowired
    private TipoCombustivelServices service;

    // Acessa o método findAll() do TipoCombustivelService
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoCombustivelDTO> findAll() {
        return service.findAll();
    }

    // Acessa o método findById() do TipoCombustivelService
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TipoCombustivelDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // Acessa o método create() do TipoCombustivelService
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TipoCombustivelDTO create(@RequestBody TipoCombustivelDTO tipoCombustivelDTO) {
        return service.create(tipoCombustivelDTO);
    }

    // Acessa o método update() do TipoCombustivelService
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TipoCombustivelDTO update(@RequestBody TipoCombustivelDTO tipoCombustivelDTO) {
        return service.update(tipoCombustivelDTO);
    }

    // Acessa o método delete() do TipoCombustivelService
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
