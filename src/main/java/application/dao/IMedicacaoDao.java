package application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.Medicacao;

@Repository
public interface IMedicacaoDao extends JpaRepository<Medicacao, Long> {
	Optional<Medicacao> findByNome(String nome);
}
