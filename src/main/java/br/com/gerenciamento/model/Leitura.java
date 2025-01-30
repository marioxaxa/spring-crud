package br.com.gerenciamento.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    @CreationTimestamp
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "semafaro_id", nullable = false)
    private Semafaro semafaro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "temperatura_id", referencedColumnName = "id")
    private Temperatura temperatura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chuva_id", referencedColumnName = "id")
    private Chuva chuva;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ruido_id", referencedColumnName = "id")
    private Ruido ruido;


    // Construtor padrão
    public Leitura() {
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Semafaro getSemafaro() {
        return semafaro;
    }

    public void setSemafaro(Semafaro semafaro) {
        this.semafaro = semafaro;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    public Chuva getChuva() {
        return chuva;
    }

    public void setChuva(Chuva chuva) {
        this.chuva = chuva;
    }

    public Ruido getRuido() {
        return ruido;
    }

    public void setRuido(Ruido ruido) {
        this.ruido = ruido;
    }
}
