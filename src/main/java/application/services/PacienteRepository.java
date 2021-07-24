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

	List<Paciente> findByNome(String nome);

	Paciente findById(long id);
}
