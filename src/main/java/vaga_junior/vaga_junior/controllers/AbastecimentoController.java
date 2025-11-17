package vaga_junior.vaga_junior.controllers;

import vaga_junior.vaga_junior.data.dto.AbastecimentoDTO;
import vaga_junior.vaga_junior.services.AbastecimentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController implements vaga_junior.vaga_junior.controllers.docs.AbastecimentoControllerDocs {

    @Autowired
    private AbastecimentoServices service;

    // Acessa o método findAll() do AbastecimentoService
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbastecimentoDTO> findAll() {
        return service.findAll();
    }

    // Acessa o método findById() do AbastecimentoService
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AbastecimentoDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // Acessa o método create() do AbastecimentoService
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AbastecimentoDTO create(@RequestBody AbastecimentoDTO abastecimentoDTO) {
        return service.create(abastecimentoDTO);
    }

    // Acessa o método update() do AbastecimentoService
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AbastecimentoDTO update(@RequestBody AbastecimentoDTO abastecimentoDTO) {
        return service.update(abastecimentoDTO);
    }

    // Acessa o método delete() do AbastecimentoService
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    } 
}