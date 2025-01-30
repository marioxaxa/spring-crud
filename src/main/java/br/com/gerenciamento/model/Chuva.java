package br.com.gerenciamento.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Chuva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "analog")
    @NotBlank(message = "O valor analogico não pode ser vazio")
    @NotNull
    private Integer analog;

    @Column(name = "digital")
    @NotBlank(message = "O valor digital não pode ser vazio")
    @NotNull
    private Integer digital;

    @OneToOne(mappedBy = "chuva")
    private Leitura leitura;

    public Chuva() {

    }
}
