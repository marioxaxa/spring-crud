package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Leitura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraRepository extends JpaRepository<Leitura, Long> {
}
