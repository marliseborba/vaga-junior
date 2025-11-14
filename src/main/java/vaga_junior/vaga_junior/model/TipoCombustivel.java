package vaga_junior.vaga_junior.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tipos_combustivel")
public class TipoCombustivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco_litro")
    private BigDecimal PrecoLitro;

    public TipoCombustivel() {
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

    public BigDecimal getPrecoLitro() {
        return PrecoLitro;
    }

    public void setPrecoLitro(BigDecimal precoLitro) {
        PrecoLitro = precoLitro;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TipoCombustivel that)) return false;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getPrecoLitro(), that.getPrecoLitro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getPrecoLitro());
    }
}
