package com.projectoFinal.casaDosAnimais.Servicos.validacao;


import com.projectoFinal.casaDosAnimais.DAO.ClienteDAO;
import  com.projectoFinal.casaDosAnimais.DTO.ClienteNewDTO;
import com.projectoFinal.casaDosAnimais.dominio.Cliente;
import com.projectoFinal.casaDosAnimais.resources.execoes.FieldMessage;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteInsertValidator  implements ConstraintValidator<ClienteInsert, ClienteNewDTO>{

	@Autowired
	private ClienteDAO clienteDados;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

		
	
	@Override
	public boolean isValid(ClienteNewDTO value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		
		Cliente aux = clienteDados.findByEmail(value.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	
	
	

}
