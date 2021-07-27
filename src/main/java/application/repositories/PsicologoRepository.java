/**
 * 
 */
package application.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import application.models.Psicologo;


public interface PsicologoRepository extends CrudRepository<Psicologo, Long> {
	Optional<Psicologo> findBycrp(String crp);
	
}
