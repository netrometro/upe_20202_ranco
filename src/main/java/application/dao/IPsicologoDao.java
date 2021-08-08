/**
 * 
 */
package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import application.models.Psicologo;


public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
	Optional<Psicologo> findBycrp(String crp);
	
}
