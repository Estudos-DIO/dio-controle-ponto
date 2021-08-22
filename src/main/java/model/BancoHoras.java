package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter                 // implementa os Getters
@Setter                 // implementa os Setters
@AllArgsConstructor     // todos os contrutores com argumento
@NoArgsConstructor      // contrutor sem argumento
@EqualsAndHashCode      // implementa hashCode e equals
@Builder                // instanciação pelo build
@Entity
public class BancoHoras {

    @AllArgsConstructor
    //@NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BancoHorasId implements Serializable {
        private Long idBancoHoras;
        private Long idMovimentacao;
        private Long idUsuario;
    }

    @EmbeddedId
    private BancoHorasId id;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;

}
