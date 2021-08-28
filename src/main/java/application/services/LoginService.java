package application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		Paciente paciente = pacienteDao.findByEmail(email);
		Psicologo psicologo = psicologoDao.findByEmail(email);
		if(paciente.getEmail().equals(email) || psicologo.getEmail().equals(email)) {
			if(paciente.getSenha().equals(pass) || psicologo.getSenha().equals(pass)) {
				return true;
			}
		}
		return false;
	}

}
