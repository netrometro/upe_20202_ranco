package application.repositories;

import org.springframework.data.repository.CrudRepository;

import application.models.Medicacao;

public interface MedicacaoRepository extends CrudRepository<Medicacao, Long> {
	Medicacao findByNome(String nome);
}
