package vaga_junior.vaga_junior.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import vaga_junior.vaga_junior.model.BombaCombustivel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class AbastecimentoDTO implements Serializable {

    private Long id;

    // Formata o campo de Data
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;
    private BigDecimal litros;

    // Define o campo valor para somente leitura, pois o valor será calculado automaticamente
    // no AbastecimentoService
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String valor;
    private BombaCombustivelDTO bomba;

    public AbastecimentoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public BombaCombustivelDTO getBomba() {
        return bomba;
    }

    public void setBomba(BombaCombustivelDTO bomba) {
        this.bomba = bomba;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbastecimentoDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getData(), that.getData()) && Objects.equals(getLitros(), that.getLitros()) && Objects.equals(getValor(), that.getValor()) && Objects.equals(getBomba(), that.getBomba());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getLitros(), getValor(), getBomba());
    }
}
