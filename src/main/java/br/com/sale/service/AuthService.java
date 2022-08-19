package br.com.sale.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sale.repositories.ClientRepository;
import br.com.sale.services.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BCryptPasswordEncoder be;

	private Random rand = new Random();

	// @Autowired
	// private EmailService emailSevice;

	public void sendNewPassword(String email) {
		var client = clientRepository.findByEmail(email);
		if (client == null) {
			throw new ObjectNotFoundException("Credenciais Inválidas");
		}
		var newPass = newPassword();
		client.setSenha(be.encode(newPass));
		clientRepository.save(client);
		// emailSevice.sendNewPasswordEmail(client, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[1] = randowChar();
		}
		return new String(vet);
	}

	private char randowChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) {
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		} else {
			return (char) (rand.nextInt(26) + 97);
		}
	}

}
