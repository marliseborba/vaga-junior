package vaga_junior.vaga_junior.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bombas_combustivel")
public class BombaCombustivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "tipo_combustivel_id")
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
