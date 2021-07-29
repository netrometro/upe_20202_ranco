package application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import application.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	Optional<Evento> findByNome(String id_evento);

}
