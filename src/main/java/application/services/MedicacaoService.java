package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Medicacao;
import application.models.Paciente;
import application.repositories.MedicacaoRepository;
import application.repositories.PacienteRepository;

@Service
public class MedicacaoService {

	@Autowired
	private MedicacaoRepository medicacoes;
	
	@Autowired
	private PacienteRepository pacientes;

	public ResponseEntity<List<Medicacao>> findAll() {
		return ResponseEntity.ok(medicacoes.findAll());
	}

	public ResponseEntity<Medicacao> findById(Long medicacao_id) {
		Optional<Medicacao> medicacao = medicacoes.findById(medicacao_id);
		if (!medicacao.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicacao.get());
	}	
	
	public ResponseEntity<Medicacao> create(long paciente_id, Medicacao medicacao){
		Optional<Paciente> paciente = pacientes.findById(paciente_id);
		if(!paciente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		medicacao.setUsuario(paciente.get());
		return ResponseEntity.ok(medicacoes.save(medicacao));
	}
	
	public ResponseEntity<Medicacao> update(long id, Medicacao medicacaoParam){
		Optional<Medicacao> medicacao = medicacoes.findById(id);
		if(!medicacao.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if(!(medicacaoParam.getNome() ==null)) {
			medicacao.get().setNome(medicacaoParam.getNome());
		}
		if(!(medicacaoParam.getPosologia() == null)) {
			medicacao.get().setPosologia(medicacaoParam.getPosologia());
		}

		return ResponseEntity.ok(medicacoes.save(medicacao.get()));
		
	}
	
	public ResponseEntity<Medicacao> delete(long id)
	{
		Optional<Medicacao> medicacao = medicacoes.findById(id);
		if(!medicacao.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		medicacoes.delete(medicacao.get());
		return ResponseEntity.ok(medicacao.get());
	}
}
