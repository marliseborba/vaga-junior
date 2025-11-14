package vaga_junior.vaga_junior.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class Abastecimento implements Serializable {

    private Long id;
    private LocalDate data;
    private BigDecimal litros;
    private BigDecimal valor;
    private BombaCombustivel bomba;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BombaCombustivel getBomba() {
        return bomba;
    }

    public void setBomba(BombaCombustivel bomba) {
        this.bomba = bomba;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Abastecimento that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getData(), that.getData()) && Objects.equals(getLitros(), that.getLitros()) && Objects.equals(getValor(), that.getValor()) && Objects.equals(getBomba(), that.getBomba());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getLitros(), getValor(), getBomba());
    }
}
