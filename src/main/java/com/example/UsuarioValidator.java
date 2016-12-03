package com.example;

import org.h2.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.data.Usuario;

@Component("beforeCreateUsuarioValidator")
public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario)target;
		if(StringUtils.isNullOrEmpty(usuario.getUsername())){
			errors.rejectValue("username", "1","El nombre de Usuario no puede ser nulo o vacio");
		}

	}

}
