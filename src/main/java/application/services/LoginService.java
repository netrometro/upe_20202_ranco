package application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.IPacienteDAO;
import application.dao.IPsicologoDao;
import application.dto.AccountDTO;
import application.dto.UsuarioDTO;
import application.models.Paciente;
import application.models.Psicologo;
import javassist.NotFoundException;

@Service
public class LoginService {

	@Autowired
	IPsicologoDao psicologoDao;
	@Autowired
	IPacienteDAO pacienteDao;
	@Autowired
	PacienteCRUDService pacientes;
	@Autowired
	PsicologoCRUDService psicologos;
	@Autowired
	PasswordEncriptionAndDecription encription;
	
	public UsuarioDTO login(AccountDTO account) throws NotFoundException {
		String email = account.getEmail();
		String pass = encription.encode(account.getPassword());
		Optional<Paciente> paciente = pacienteDao.findByEmail(email);
		Optional<Psicologo> psicologo = psicologoDao.findByEmail(email);
		if(paciente.isPresent()) {
			if(paciente.get().getEmail().equals(email) && paciente.get().getSenha().equals(pass)) {
				return new UsuarioDTO(paciente.get().getId(), paciente.get().getNome(), paciente.get().getEmail(), paciente.get().getTipoUsuario());
			}
		}
		if(psicologo.isPresent()) {
			if(psicologo.get().getEmail().equals(email) && psicologo.get().getSenha().equals(pass)) {
				return new UsuarioDTO(psicologo.get().getId(), psicologo.get().getNome(), psicologo.get().getEmail(), psicologo.get().getTipoUsuario());
			}
		}
		throw new NotFoundException("Email ou senha inválidos");
	}

}
