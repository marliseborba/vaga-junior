package vaga_junior.vaga_junior.services;

import vaga_junior.vaga_junior.model.BombaCombustivel;
import vaga_junior.vaga_junior.repository.BombaCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BombaCombustivelServices {

    @Autowired
    BombaCombustivelRepository repository;

    public List<BombaCombustivel> findAll() {
        return repository.findAll();
    }

    public Optional<BombaCombustivel> findById(Long id) {
        return repository.findById(id);
    }

    public BombaCombustivel create(BombaCombustivel bombaCombustivel) {
        return repository.save(bombaCombustivel);
    }

    public BombaCombustivel update(BombaCombustivel bombaCombustivel) {
        Optional<BombaCombustivel> entity = repository.findById(bombaCombustivel.getId());

        entity.get().setNome(bombaCombustivel.getNome());
        entity.get().setCombustivel(bombaCombustivel.getCombustivel());

        return repository.save(entity.get());
    }

    public void delete(Long id) {
        Optional<BombaCombustivel> entity = repository.findById(id);

        repository.delete(entity.get());
    }
}
