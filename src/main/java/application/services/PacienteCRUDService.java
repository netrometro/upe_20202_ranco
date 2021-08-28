package application.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.IPacienteDAO;
import application.dto.PacienteDTO;
import application.models.Paciente;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PacienteCRUDService {

	@Autowired
	private IPacienteDAO pacientes;
	@Autowired
	private PasswordEncriptionAndDecription encription;

	public List<PacienteDTO> findAll() {
		List<Paciente> findAll = pacientes.findAll();
		List<PacienteDTO> list = new ArrayList<PacienteDTO>();
		for (Paciente p : findAll) {
			list.add(new PacienteDTO(p.getNome(), p.getEmail(), p.getTipoUsuario(), p.getEventos(), p.getMedicacoes()));
		}
		return list;
	}

	public PacienteDTO findById(Long id_paciente) {
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		if (!paciente.isPresent()) {
			return null;
		} else {
			PacienteDTO pacientedto = new PacienteDTO(paciente.get().getNome(), paciente.get().getEmail(),
					paciente.get().getTipoUsuario(), paciente.get().getEventos(), paciente.get().getMedicacoes());
			return pacientedto;
		}
	}

	public PacienteDTO create(Paciente pacienteParam) {
		String encodedPass = encription.encode(pacienteParam.getSenha());
		pacienteParam.setSenha(encodedPass);
		pacienteParam.setDataInclusao(LocalDateTime.now());
		Paciente paciente = pacientes.save(pacienteParam);
		PacienteDTO pacientedto = new PacienteDTO(paciente.getNome(), paciente.getEmail(), paciente.getTipoUsuario(),
				paciente.getEventos(), paciente.getMedicacoes());
		return pacientedto;
	}

	public PacienteDTO delete(Long id_paciente) {

		if (pacientes.existsById(id_paciente)) {
			Optional<Paciente> paciente = pacientes.findById(id_paciente);
			pacientes.delete(paciente.get());
			PacienteDTO pacientedto = new PacienteDTO(paciente.get().getNome(), paciente.get().getEmail(),
					paciente.get().getTipoUsuario(), paciente.get().getEventos(), paciente.get().getMedicacoes());
			return pacientedto;
		}
		return null;
	}

	public PacienteDTO update(Long id_paciente, Paciente pacienteParam) {
		Optional<Paciente> paciente = pacientes.findById(id_paciente);

		if (!paciente.isPresent()) {
			return null;
		}

		if (!(pacienteParam.getNome() == null)) {
			paciente.get().setNome(pacienteParam.getNome());
		}
		if (!(pacienteParam.getEmail() == null)) {
			paciente.get().setEmail(pacienteParam.getEmail());
		}
		if (!(pacienteParam.getSenha() == null)) {
			paciente.get().setSenha(pacienteParam.getSenha());
		}
		if (!(pacienteParam.getTipoUsuario() == null)) {
			paciente.get().setTipoUsuario(pacienteParam.getTipoUsuario());
		}
		paciente.get().setDataModificacao(LocalDateTime.now());
		PacienteDTO pacientedto = new PacienteDTO(paciente.get().getNome(), paciente.get().getEmail(),
				paciente.get().getTipoUsuario(), paciente.get().getEventos(), paciente.get().getMedicacoes());
		return pacientedto;		

	}

}
