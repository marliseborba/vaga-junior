package vaga_junior.vaga_junior.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import vaga_junior.vaga_junior.controllers.docs.TipoCombustivelControllerDocs;
import vaga_junior.vaga_junior.data.dto.TipoCombustivelDTO;
import vaga_junior.vaga_junior.services.TipoCombustivelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposcombustivel")
@Tag(name = "TipoCombustivel", description = "Endpoinst to managing TipoCombustivel")
public class TipoCombustivelController implements TipoCombustivelControllerDocs {

    @Autowired
    private TipoCombustivelServices service;

    // Acessa o método findAll() do TipoCombustivelService
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<TipoCombustivelDTO> findAll() {
        return service.findAll();
    }

    // Acessa o método findById() do TipoCombustivelService
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public TipoCombustivelDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // Acessa o método create() do TipoCombustivelService
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public TipoCombustivelDTO create(@RequestBody TipoCombustivelDTO tipoCombustivelDTO) {
        return service.create(tipoCombustivelDTO);
    }

    // Acessa o método update() do TipoCombustivelService
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public TipoCombustivelDTO update(@RequestBody TipoCombustivelDTO tipoCombustivelDTO) {
        return service.update(tipoCombustivelDTO);
    }

    // Acessa o método delete() do TipoCombustivelService
    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
