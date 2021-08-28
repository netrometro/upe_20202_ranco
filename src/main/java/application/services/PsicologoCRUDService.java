package application.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Psicologo;
import application.dao.IMedicacaoDao;
import application.dao.IPsicologoDao;
import application.dto.PacienteDTO;
import application.dto.PsicologoDTO;
import application.dao.IPacienteDAO;
import application.models.Paciente;

@Service
public class PsicologoCRUDService {
	@Autowired
	private IPsicologoDao psicologos;

	@Autowired
	private IPacienteDAO pacientes;

	@Autowired
	private PasswordEncriptionAndDecription encription;

	public List<PsicologoDTO> findAll() {
		List<Psicologo> findAll = psicologos.findAll();
		List<PsicologoDTO> list = new ArrayList<PsicologoDTO>();
		for (Psicologo p : findAll) {
			list.add(new PsicologoDTO(p.getId(), p.getNome(), p.getEmail(), p.getTipoUsuario(), p.getCrp()));
		}
		return list;
	}

	public PsicologoDTO findById(Long id) {
		Optional<Psicologo> psicologo = psicologos.findById(id);
		if (!psicologo.isPresent()) {
			return null;
		}
		PsicologoDTO psicologoDTO = new PsicologoDTO(psicologo.get().getId(), psicologo.get().getNome(),
				psicologo.get().getEmail(), psicologo.get().getTipoUsuario(), psicologo.get().getCrp());
		return psicologoDTO;
	}

	public PsicologoDTO create(Psicologo psicologo) {
		Optional<Psicologo> findByEmail = psicologos.findByEmail(psicologo.getEmail());
		if(findByEmail.isPresent()) {
			return null;
		}
		String encodedPass = encription.encode(psicologo.getSenha());
		psicologo.setSenha(encodedPass);
		psicologo.setDataInclusao(LocalDateTime.now());
		psicologos.save(psicologo);
		PsicologoDTO psicologoDTO = new PsicologoDTO(psicologo.getId(), psicologo.getNome(), psicologo.getEmail(),
				psicologo.getTipoUsuario(), psicologo.getCrp());
		return psicologoDTO;
	}

	public PsicologoDTO update(long id, Psicologo psicologoP) {
		Optional<Psicologo> psicologo = psicologos.findById(id);

		if (!psicologo.isPresent()) {
			return null;
		}
		if (!(psicologoP.getNome() == null)) {
			psicologo.get().setNome(psicologoP.getNome());
		}
		if (!(psicologoP.getEmail() == null)) {
			psicologo.get().setEmail(psicologoP.getEmail());
		}
		if (!(psicologoP.getSenha() == null)) {
			psicologo.get().setSenha(psicologoP.getSenha());
		}
		if (!(psicologoP.getTipoUsuario() == null)) {
			psicologo.get().setTipoUsuario(psicologoP.getTipoUsuario());
		}
		if (!(psicologoP.getCrp() == null)) {
			psicologo.get().setCrp(psicologoP.getCrp());
		}
		psicologo.get().setDataModificacao(LocalDateTime.now());
		psicologos.save(psicologo.get());
		PsicologoDTO psicologoDTO = new PsicologoDTO(psicologo.get().getId(), psicologo.get().getNome(),
				psicologo.get().getEmail(), psicologo.get().getTipoUsuario(), psicologo.get().getCrp());
		return psicologoDTO;
	}

	public PsicologoDTO delete(long id) {
		Optional<Psicologo> psicologo = psicologos.findById(id);
		if (!psicologo.isPresent()) {
			return null;
		}
		psicologos.delete(psicologo.get());
		PsicologoDTO psicologoDTO = new PsicologoDTO(psicologo.get().getId(), psicologo.get().getNome(), psicologo.get().getEmail(),
				psicologo.get().getTipoUsuario(), psicologo.get().getCrp());
		return psicologoDTO;
	}
}
