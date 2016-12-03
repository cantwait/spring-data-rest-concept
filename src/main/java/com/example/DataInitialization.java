package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.data.Usuario;
import com.example.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataInitialization implements CommandLineRunner {
	
	
	private UsuarioRepository usuarioRepository;
	
	public DataInitialization(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Creating user...");
		Usuario user1 = new Usuario();
		user1.setNombre("Rafael");
		user1.setLastname("Cadenas");
		user1.setUsername("rcadenas");
		log.info("Persisting user --> {}", user1.toString());
		usuarioRepository.save(user1);
	}

}
