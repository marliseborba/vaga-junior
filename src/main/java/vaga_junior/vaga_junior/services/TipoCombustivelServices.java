package vaga_junior.vaga_junior.services;

import vaga_junior.vaga_junior.model.TipoCombustivel;
import vaga_junior.vaga_junior.repository.TipoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCombustivelServices {

    @Autowired
    TipoCombustivelRepository repository;

    public List<TipoCombustivel> findAll() {
        return repository.findAll();
    }

    public Optional<TipoCombustivel> findById(Long id) {
        return repository.findById(id);
    }

    public TipoCombustivel create(TipoCombustivel tipoCombustivel) {
        return repository.save(tipoCombustivel);
    }

    public TipoCombustivel update(TipoCombustivel tipoCombustivel) {
        Optional<TipoCombustivel> entity = repository.findById(tipoCombustivel.getId());

        entity.get().setNome(tipoCombustivel.getNome());
        entity.get().setPrecoLitro(tipoCombustivel.getPrecoLitro());

        return repository.save(entity.get());
    }

    public void delete(Long id) {
        Optional<TipoCombustivel> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
