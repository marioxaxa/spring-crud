package br.com.gerenciamento.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Semafaro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String cep;

    private String numero;

    @OneToMany(mappedBy = "semafaro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Leitura> leituras;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Leitura> getLeituras() {
        return leituras;
    }

    public void setLeituras(List<Leitura> leituras) {
        this.leituras = leituras;
    }
}
