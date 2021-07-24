/**
 * 
 */
package application.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import application.models.Paciente;

/**
 * @author Dahise
 *
 */
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

	List<Paciente> findByLastName(String lastName);

	Paciente findById(long id);
}
