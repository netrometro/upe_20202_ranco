package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.AccountDTO;
import application.dto.UsuarioDTO;
import application.models.abstracts.Usuario;
import application.services.LoginService;
import javassist.NotFoundException;

@RequestMapping("/api/login")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<UsuarioDTO> login(@RequestBody AccountDTO account) {
		UsuarioDTO login;
		try {
			System.out.println(account.toString());
			login = loginService.login(account);
			return ResponseEntity.ok(login);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
}
