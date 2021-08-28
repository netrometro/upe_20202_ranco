/**
 * 
 */
package application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.Paciente;
import application.models.Psicologo;

@Repository
public interface IPsicologoDao extends JpaRepository<Psicologo, Long> {
	Optional<Psicologo> findBycrp(String crp);
	Psicologo findByEmail(String email);
	
}
