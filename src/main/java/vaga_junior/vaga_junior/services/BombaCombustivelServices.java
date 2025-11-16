package vaga_junior.vaga_junior.services;

import vaga_junior.vaga_junior.data.dto.BombaCombustivelDTO;
import vaga_junior.vaga_junior.data.dto.TipoCombustivelDTO;
import vaga_junior.vaga_junior.exception.ResourceNotFoundException;
import vaga_junior.vaga_junior.model.BombaCombustivel;
import vaga_junior.vaga_junior.model.TipoCombustivel;
import vaga_junior.vaga_junior.repository.BombaCombustivelRepository;
import static vaga_junior.vaga_junior.mapper.ObjectMapper.parseListObjects;
import static vaga_junior.vaga_junior.mapper.ObjectMapper.parseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaga_junior.vaga_junior.repository.TipoCombustivelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BombaCombustivelServices {

    @Autowired
    BombaCombustivelRepository repository;
    @Autowired
    TipoCombustivelRepository tipoCombustivelRepository;

    public List<BombaCombustivelDTO> findAll() {
        return parseListObjects(repository.findAll(), BombaCombustivelDTO.class);
    }

    public BombaCombustivelDTO findById(Long id) {
        return parseObject(parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")), BombaCombustivel.class), BombaCombustivelDTO.class);
    }

    public BombaCombustivelDTO create(BombaCombustivelDTO bombaCombustivelDTO) {
        BombaCombustivel entity = repository.save(parseObject(bombaCombustivelDTO, BombaCombustivel.class));
        repository.save(entity);
        bombaCombustivelDTO = parseObject(entity, BombaCombustivelDTO.class);
        TipoCombustivel combustivel = tipoCombustivelRepository.findById(bombaCombustivelDTO.getCombustivel().getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        bombaCombustivelDTO.setCombustivel(parseObject(combustivel, TipoCombustivelDTO.class));
        return bombaCombustivelDTO;
    }

    public BombaCombustivelDTO update(BombaCombustivelDTO bombaCombustivelDTO) {
        BombaCombustivel entity = repository.findById(bombaCombustivelDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setNome(bombaCombustivelDTO.getNome());
        entity.setCombustivel(parseObject(bombaCombustivelDTO.getCombustivel(), TipoCombustivel.class));
        repository.save(entity);
        bombaCombustivelDTO = parseObject(entity, BombaCombustivelDTO.class);
        TipoCombustivel combustivel = tipoCombustivelRepository.findById(bombaCombustivelDTO.getCombustivel().getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        bombaCombustivelDTO.setCombustivel(parseObject(combustivel, TipoCombustivelDTO.class));
        return bombaCombustivelDTO;
    }

    public void delete(Long id) {
        Optional<BombaCombustivel> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
