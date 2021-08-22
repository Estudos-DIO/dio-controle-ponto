package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter                 // implementa os Getters
@Setter                 // implementa os Setters
@AllArgsConstructor     // todos os contrutores com argumento
@NoArgsConstructor      // contrutor sem argumento
@EqualsAndHashCode      // implementa hashCode e equals
@Builder                // instanciação pelo build
@Entity
public class Usuario {

    @Id
    private Long id;

    private String nome;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelDeAcesso nivelDeAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;

    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime fimJornada;

}