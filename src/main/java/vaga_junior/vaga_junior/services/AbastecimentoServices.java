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

import java.math.RoundingMode;
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

    // Retorna todos os registros da tabela abastecimentos
    public List<AbastecimentoDTO> findAll() {
        return parseListObjects(repository.findAll(), AbastecimentoDTO.class);
    }

    // Retorna um registro da tabela abastecimentos pelo ID
    public AbastecimentoDTO findById(Long id) {
        return parseObject(parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!")), Abastecimento.class), AbastecimentoDTO.class);
    }

    // Cria um registro na tabela abastecimentos
    public AbastecimentoDTO create(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento entity = parseObject(abastecimentoDTO, Abastecimento.class);
        BombaCombustivel bomba = bombaCombustivelRepository.findById(abastecimentoDTO.getBomba().getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        TipoCombustivel combustivel = tipoCombustivelRepository.findById(bomba.getCombustivel().getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
        bomba.setCombustivel(combustivel);
        abastecimentoDTO.setBomba(parseObject(bomba, BombaCombustivelDTO.class));

        // Define o campo valor multiplicando a quantidade de litros pelo preço do litro
        entity.setValor(abastecimentoDTO.getLitros().multiply(combustivel.getPrecoLitro()).setScale(2, RoundingMode.HALF_UP));
        repository.save(entity);
        abastecimentoDTO = parseObject(entity, AbastecimentoDTO.class);
        abastecimentoDTO.setBomba(parseObject(bomba, BombaCombustivelDTO.class));
        return abastecimentoDTO;
    }

    // Altera um registro na tabela abastecimentos pelo ID
    public AbastecimentoDTO update(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento entity = repository.findById(abastecimentoDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));

        entity.setData(abastecimentoDTO.getData());
        entity.setLitros(abastecimentoDTO.getLitros());

        // Define o campo valor multiplicando a quantidade de litros pelo preço do litro
        entity.setValor(entity.getLitros().multiply(entity.getBomba().getCombustivel().getPrecoLitro()));

        return parseObject(repository.save(entity),AbastecimentoDTO.class);
    }

    // Deleta um registro da tabela abastecimentos pelo ID
    public void delete(Long id) {
        Optional<Abastecimento> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
