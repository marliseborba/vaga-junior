package vaga_junior.vaga_junior.model;

import java.io.Serializable;
import java.util.Objects;

public class BombaCombustivel implements Serializable {

    private Long id;
    private String nome;
    private TipoCombustivel combustivel;

    public BombaCombustivel() {
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

    public TipoCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(TipoCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BombaCombustivel that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getCombustivel(), that.getCombustivel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCombustivel());
    }
}
