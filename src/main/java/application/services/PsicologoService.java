package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Psicologo;
import application.models.Paciente;
import application.repositories.MedicacaoRepository;
import application.repositories.IPacienteDAO;
import application.repositories.PsicologoRepository;

@Service
public class PsicologoService {
	@Autowired
	private PsicologoRepository psicologos;

	@Autowired
	private IPacienteDAO pacientes;

	public List<Psicologo> findAll() {
		return psicologos.findAll();
	}

	public Psicologo findById(Long id) {
		Optional<Psicologo> psicologo = psicologos.findById(id);
		if (!psicologo.isPresent()) {
			return null;
		}
		return psicologo.get();
	}

	public Psicologo create(Psicologo psicologo) {		
		return psicologos.save(psicologo);
	}

	public Psicologo update(long id, Psicologo psicologoP) {
		Optional<Psicologo> psicologo = psicologos.findById(id);		
        
        if(!psicologo.isPresent()) {
            return null;
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

		return psicologos.save(psicologo.get());

	}

	public Psicologo delete(long id) {
		Optional<Psicologo> psicologo = psicologos.findById(id);
		if (!psicologo.isPresent()) {
			return null;
		}
		psicologos.delete(psicologo.get());
		return psicologo.get();
	}
}
