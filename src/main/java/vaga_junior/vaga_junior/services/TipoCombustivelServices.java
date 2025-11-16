package vaga_junior.vaga_junior.services;

import vaga_junior.vaga_junior.data.dto.TipoCombustivelDTO;
import vaga_junior.vaga_junior.exception.ResourceNotFoundException;
import vaga_junior.vaga_junior.model.TipoCombustivel;
import vaga_junior.vaga_junior.repository.TipoCombustivelRepository;
import static vaga_junior.vaga_junior.mapper.ObjectMapper.parseListObjects;
import static vaga_junior.vaga_junior.mapper.ObjectMapper.parseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCombustivelServices {

    @Autowired
    TipoCombustivelRepository repository;

    public List<TipoCombustivelDTO> findAll() {
        return parseListObjects(repository.findAll(), TipoCombustivelDTO.class);
    }

    public TipoCombustivelDTO findById(Long id) {
        return parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")), TipoCombustivelDTO.class);
    }

    public TipoCombustivelDTO create(TipoCombustivelDTO tipoCombustivelDTO) {
        return parseObject(repository.save(parseObject(tipoCombustivelDTO, TipoCombustivel.class)), TipoCombustivelDTO.class);
    }

    public TipoCombustivelDTO update(TipoCombustivelDTO tipoCombustivelDTO) {
        TipoCombustivel entity = repository.findById(tipoCombustivelDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setNome(tipoCombustivelDTO.getNome());
        entity.setPrecoLitro(tipoCombustivelDTO.getPrecoLitro());
        return parseObject(repository.save(entity), TipoCombustivelDTO.class);
    }

    public void delete(Long id) {
        Optional<TipoCombustivel> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
