package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperaturaRepository extends JpaRepository<Temperatura, Long> {
}
