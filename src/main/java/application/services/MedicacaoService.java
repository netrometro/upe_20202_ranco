package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Medicacao;
import application.repositories.MedicacaoRepository;

@Service
public class MedicacaoService {

	@Autowired
	private MedicacaoRepository medicacoes;
	
	public ResponseEntity<List<Medicacao>> findAll(){
		return ResponseEntity.ok(medicacoes.findAll());
	}
	
	public ResponseEntity<Medicacao> findById(Long medicacao_id){		
		Optional<Medicacao> medicacao = medicacoes.findById(medicacao_id);
		if(!medicacao.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicacao.get());
	}
}
