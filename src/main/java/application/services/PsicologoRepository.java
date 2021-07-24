/**
 * 
 */
package application.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import application.models.Psicologo;

/**
 * @author Dahis
 *
 */
public interface PsicologoRepository extends CrudRepository<Psicologo, Long> {
	List<Psicologo> findBycrp(String crp);

	Psicologo findById(long id);
}
