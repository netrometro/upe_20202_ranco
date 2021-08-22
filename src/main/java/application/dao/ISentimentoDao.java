package application.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.Sentimento;

@Repository
public interface ISentimentoDao extends JpaRepository<Sentimento, Long>{

}
