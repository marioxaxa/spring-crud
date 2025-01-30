package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Ruido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuidoRepository extends JpaRepository<Ruido, Long> {
}
