package model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter                 // implementa os Getters
@Setter                 // implementa os Setters
@AllArgsConstructor     // todos os contrutores com argumento
@NoArgsConstructor      // contrutor sem argumento
@EqualsAndHashCode      // implementa hashCode e equals
@Builder                // instanciação pelo build
@Entity
@Audited                // permitir auditoria na tabela
public class JornadaTrabalho {

    @ApiModelProperty(value = "Identificador da jornada de trabalho.", reference = "false")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Descrição da jornada de trabalho.", reference = "true")
    private String descricao;

}
