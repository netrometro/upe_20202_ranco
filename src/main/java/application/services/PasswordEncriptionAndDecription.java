package application.services;

import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncriptionAndDecription {
	
	public String encode(String plainText) {
		return Base64.getEncoder().encodeToString(plainText.getBytes());
	}
	
	public String decode(String encripted) {
		return new String(Base64.getMimeDecoder().decode(encripted.getBytes()));
	}
}
