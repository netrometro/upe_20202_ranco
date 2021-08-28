/**
 * 
 */
package application.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import application.models.Paciente;

/**
 * camada de acesso a dados da entidade paciente
 * @author Dahise
 */
public interface IPacienteDAO extends JpaRepository<Paciente, Long> {

	List<Paciente> findByNome(String nome);
	Paciente findByEmail(String email);
}
