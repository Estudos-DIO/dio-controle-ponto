package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter                 // implementa os Getters
@Setter                 // implementa os Setters
@AllArgsConstructor     // todos os contrutores com argumento
@NoArgsConstructor      // contrutor sem argumento
@EqualsAndHashCode      // implementa hashCode e equals
@Builder                // instanciação pelo build
@Entity
public class Ocorrencia {

    @Id
    private Long id;

    private String nome;
    private String descricao;

}
