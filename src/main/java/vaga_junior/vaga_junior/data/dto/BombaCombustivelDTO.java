package vaga_junior.vaga_junior.data.dto;

import jakarta.persistence.*;
import vaga_junior.vaga_junior.model.TipoCombustivel;

import java.io.Serializable;
import java.util.Objects;

public class BombaCombustivelDTO implements Serializable {

    private Long id;
    private String nome;
    private TipoCombustivelDTO combustivel;

    public BombaCombustivelDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCombustivelDTO getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(TipoCombustivelDTO combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BombaCombustivelDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getCombustivel(), that.getCombustivel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCombustivel());
    }
}
