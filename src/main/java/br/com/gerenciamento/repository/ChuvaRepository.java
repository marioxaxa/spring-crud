package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Chuva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChuvaRepository extends JpaRepository<Chuva, Long> {
}
