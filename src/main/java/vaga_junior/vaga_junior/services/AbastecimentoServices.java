package vaga_junior.vaga_junior.services;

import vaga_junior.vaga_junior.model.Abastecimento;
import vaga_junior.vaga_junior.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoServices {
    
    @Autowired
    AbastecimentoRepository repository;

    public List<Abastecimento> findAll() {
        return repository.findAll();
    }

    public Optional<Abastecimento> findById(Long id) {
        return repository.findById(id);
    }

    public Abastecimento create(Abastecimento abastecimento) {
        return repository.save(abastecimento);
    }

    public Abastecimento update(Abastecimento abastecimento) {
        Optional<Abastecimento> entity = repository.findById(abastecimento.getId());

        entity.get().setData(abastecimento.getData());
        entity.get().setLitros(abastecimento.getLitros());
        entity.get().setValor(abastecimento.getValor());
        entity.get().setBomba(abastecimento.getBomba());

        return repository.save(entity.get());
    }

    public void delete(Long id) {
        Optional<Abastecimento> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
