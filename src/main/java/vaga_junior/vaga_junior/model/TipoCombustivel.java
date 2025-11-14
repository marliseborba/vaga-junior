package vaga_junior.vaga_junior.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TipoCombustivel implements Serializable {

    private Long id;
    private String nome;
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
