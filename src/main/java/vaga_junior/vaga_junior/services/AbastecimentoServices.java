package vaga_junior.vaga_junior.services;

import vaga_junior.vaga_junior.data.dto.AbastecimentoDTO;
import vaga_junior.vaga_junior.data.dto.BombaCombustivelDTO;
import vaga_junior.vaga_junior.data.dto.TipoCombustivelDTO;
import vaga_junior.vaga_junior.exception.ResourceNotFoundException;
import vaga_junior.vaga_junior.model.Abastecimento;
import vaga_junior.vaga_junior.model.BombaCombustivel;
import vaga_junior.vaga_junior.model.TipoCombustivel;
import vaga_junior.vaga_junior.repository.AbastecimentoRepository;
import static vaga_junior.vaga_junior.mapper.ObjectMapper.parseListObjects;
import static vaga_junior.vaga_junior.mapper.ObjectMapper.parseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaga_junior.vaga_junior.repository.BombaCombustivelRepository;
import vaga_junior.vaga_junior.repository.TipoCombustivelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoServices {
    
    @Autowired
    AbastecimentoRepository repository;
    @Autowired
    BombaCombustivelRepository bombaCombustivelRepository;
    @Autowired
    TipoCombustivelRepository tipoCombustivelRepository;

    public List<AbastecimentoDTO> findAll() {
        return parseListObjects(repository.findAll(), AbastecimentoDTO.class);
    }

    public AbastecimentoDTO findById(Long id) {
        return parseObject(parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")), Abastecimento.class), AbastecimentoDTO.class);
    }

    public AbastecimentoDTO create(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento entity = parseObject(abastecimentoDTO, Abastecimento.class);
        BombaCombustivel bomba = bombaCombustivelRepository.findById(abastecimentoDTO.getBomba().getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        TipoCombustivel combustivel = tipoCombustivelRepository.findById(bomba.getCombustivel().getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        bomba.setCombustivel(combustivel);
        abastecimentoDTO.setBomba(parseObject(bomba, BombaCombustivelDTO.class));
        entity.setValor(abastecimentoDTO.getLitros().multiply(combustivel.getPrecoLitro()));
        repository.save(entity);
        abastecimentoDTO = parseObject(entity, AbastecimentoDTO.class);
        abastecimentoDTO.setBomba(parseObject(bomba, BombaCombustivelDTO.class));
        return abastecimentoDTO;
    }

    public AbastecimentoDTO update(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento entity = repository.findById(abastecimentoDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setData(abastecimentoDTO.getData());
        entity.setLitros(abastecimentoDTO.getLitros());
        entity.setValor(entity.getLitros().multiply(entity.getBomba().getCombustivel().getPrecoLitro()));

        return parseObject(repository.save(entity),AbastecimentoDTO.class);
    }

    public void delete(Long id) {
        Optional<Abastecimento> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
