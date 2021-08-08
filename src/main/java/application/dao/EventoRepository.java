package application.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import application.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{	
}
