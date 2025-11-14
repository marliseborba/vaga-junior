package vaga_junior.vaga_junior.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "abastecimentos")
public class Abastecimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(name = "litros")
    private BigDecimal litros;

    @Column(name = "valor")
    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "bomba_combustivel_id")
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
