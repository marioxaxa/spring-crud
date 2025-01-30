package br.com.gerenciamento.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Temperatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voltagem")
    @NotBlank(message = "A voltagem não pode ser vazio")
    @NotNull
    private Integer voltagem;

    @OneToOne(mappedBy = "temperatura")
    private Leitura leitura;

    public Temperatura() {

    }
}
