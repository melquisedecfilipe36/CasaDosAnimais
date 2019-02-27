package com.projectoFinal.casaDosAnimais.Servicos.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


import com.projectoFinal.casaDosAnimais.DAO.VeterinarioDAO;
import com.projectoFinal.casaDosAnimais.DTO.VeterinarioNewDTO;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;
import com.projectoFinal.casaDosAnimais.resources.execoes.FieldMessage;



public class VeterinarioInsertValidator implements ConstraintValidator<VeterinarioInsert, VeterinarioNewDTO> {

	
	@Autowired
	private VeterinarioDAO veterinarioDados;
	
	@Override
	public void initialize(VeterinarioInsert ann) {
	}

		
	
	@Override
	public boolean isValid(VeterinarioNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		
		Veterinario vet = veterinarioDados.findByEmail(objDto.getEmail());
		if (vet != null) {
			list.add(new FieldMessage("email","Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
	
}
