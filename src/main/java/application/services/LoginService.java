package application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.IPacienteDAO;
import application.dao.IPsicologoDao;
import application.dto.AccountDTO;
import application.models.Paciente;
import application.models.Psicologo;

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
	
	public Boolean login(AccountDTO account) {
		String email = account.getEmail();
		String pass = encription.encode(account.getPassword());
		Optional<Paciente> paciente = pacienteDao.findByEmail(email);
		Optional<Psicologo> psicologo = psicologoDao.findByEmail(email);
		if(paciente.isPresent()) {
			if(paciente.get().getEmail().equals(email) && paciente.get().getSenha().equals(pass)) {
				return true;
			}
		}
		if(psicologo.isPresent()) {
			if(psicologo.get().getEmail().equals(email) && psicologo.get().getSenha().equals(pass)) {
				return true;
			}
		}
		return false;
	}

}
