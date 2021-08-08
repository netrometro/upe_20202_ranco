package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import application.models.Medicacao;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Long> {
	Optional<Medicacao> findByNome(String nome);
}
