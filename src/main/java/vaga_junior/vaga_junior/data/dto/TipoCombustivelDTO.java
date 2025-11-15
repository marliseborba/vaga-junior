package vaga_junior.vaga_junior.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TipoCombustivelDTO implements Serializable {

    private Long id;
    private String nome;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal PrecoLitro;

    public TipoCombustivelDTO() {
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
        if (!(o instanceof TipoCombustivelDTO that)) return false;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getPrecoLitro(), that.getPrecoLitro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getPrecoLitro());
    }
}
