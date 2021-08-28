/**
 * 
 */
package application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import application.models.Paciente;
import application.models.Psicologo;

/**
 * camada de acesso a dados da entidade paciente
 * @author Dahise
 */
public interface IPacienteDAO extends JpaRepository<Paciente, Long> {

	List<Paciente> findByNome(String nome);
	Optional<Paciente> findByEmail(String email);
}
