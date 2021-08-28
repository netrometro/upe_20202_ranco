package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.AccountDTO;
import application.models.abstracts.Usuario;
import application.services.LoginService;

@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody AccountDTO account){
		Boolean login = loginService.login(account);
		if(login.booleanValue() == true) {
			return ResponseEntity.ok("Sucesso"); 			
		}
		return ResponseEntity.ok("Usuário ou senha inválidos"); 			
	}
}
