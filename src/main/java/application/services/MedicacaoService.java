package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.dao.IMedicacaoDao;
import application.dao.PacienteRepository;
import application.models.Medicacao;
import application.models.Paciente;

@Service
public class MedicacaoService {
	// Response entity deve ser tratada pelo controller
	
	@Autowired
	private IMedicacaoDao medicacoes;
	
	@Autowired
	private PacienteRepository pacientes;

	public List<Medicacao> findAll() {
		return medicacoes.findAll();
	}

	public Medicacao findById(Long medicacao_id) {
		Optional<Medicacao> medicacao = medicacoes.findById(medicacao_id);
		if (!medicacao.isPresent()) {
			return null;
		}
		return medicacao.get();
	}	
	
	public Medicacao create(long paciente_id, Medicacao medicacao){
		Optional<Paciente> paciente = pacientes.findById(paciente_id);
		if(!paciente.isPresent()) {
			throw new RuntimeException(null, null);
		}
		medicacao.setUsuario(paciente.get());		
		return medicacoes.save(medicacao); 
	}
	
	public Medicacao update(long id, Medicacao medicacaoParam){
		Optional<Medicacao> medicacao = medicacoes.findById(id);
		if(!medicacao.isPresent()) {
			return null;
		}
		if(!(medicacaoParam.getNome() ==null)) {
			medicacao.get().setNome(medicacaoParam.getNome());
		}
		if(!(medicacaoParam.getPosologia() == null)) {
			medicacao.get().setPosologia(medicacaoParam.getPosologia());
		}

		return medicacoes.save(medicacao.get());
		
	}
	
	public Medicacao delete(long id)
	{
		Optional<Medicacao> medicacao = medicacoes.findById(id);
		if(!medicacao.isPresent()) {
			return null;
		}
		medicacoes.delete(medicacao.get());
		return medicacao.get();
	}
}
