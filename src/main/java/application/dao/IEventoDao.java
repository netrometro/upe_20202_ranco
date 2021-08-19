package application.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.Evento;

@Repository
public interface IEventoDao extends JpaRepository<Evento, Long>{	
	Optional<Evento> findById(String id_evento);
}
