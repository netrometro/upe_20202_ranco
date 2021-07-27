package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Psicologo;
import application.models.Paciente;
import application.repositories.MedicacaoRepository;
import application.repositories.PacienteRepository;
import application.repositories.PsicologoRepository;

@Service
public class PsicologoService {
	@Autowired
	private PsicologoRepository psicologos;

	@Autowired
	private PacienteRepository pacientes;

	public ResponseEntity<List<Psicologo>> findAll() {
		return ResponseEntity.ok(psicologos.findAll());
	}

	public ResponseEntity<Psicologo> findById(Long id) {
		Optional<Psicologo> psicologo = psicologos.findById(id);
		if (psicologo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(psicologo.get());
	}

	public ResponseEntity<Psicologo> create(Psicologo medicacao) {		
		return ResponseEntity.ok(psicologos.save(medicacao));
	}

	public ResponseEntity<Psicologo> update(long id, Psicologo psicologoP) {
		Optional<Psicologo> psicologo = psicologos.findById(id);		
        
        if(!psicologo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if(!(psicologoP.getNome() == null)) {
        	psicologo.get().setNome(psicologoP.getNome());
        }
        if(!(psicologoP.getEmail() == null)) {
            psicologo.get().setEmail(psicologoP.getEmail());
        }
        if(!(psicologoP.getSenha() == null)) {
            psicologo.get().setSenha(psicologoP.getSenha());    
        }
        if(!(psicologoP.getTipoUsuario() == null)) {
            psicologo.get().setTipoUsuario(psicologoP.getTipoUsuario());
        }
        if(!(psicologoP.getCrp() == null)) {
            psicologo.get().setCrp(psicologoP.getCrp());
        }

		return ResponseEntity.ok(psicologos.save(psicologo.get()));

	}

	public ResponseEntity<Psicologo> delete(long id) {
		Optional<Psicologo> psicologo = psicologos.findById(id);
		if (!psicologo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		psicologos.delete(psicologo.get());
		return ResponseEntity.ok(psicologo.get());
	}
}
