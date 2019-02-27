package com.projectoFinal.casaDosAnimais.Servicos.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectoFinal.casaDosAnimais.DAO.AuxiliarDAO;
import com.projectoFinal.casaDosAnimais.DTO.AuxiliarNewDTO;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;
import com.projectoFinal.casaDosAnimais.resources.execoes.FieldMessage;

public class AuxiliarInsertValidator implements ConstraintValidator<AuxiliarInsert, AuxiliarNewDTO> {

	@Autowired
	private AuxiliarDAO auxiliarDados;
	
	@Override
	public void initialize(AuxiliarInsert ann) {
	}
	
	
	@Override
	public boolean isValid(AuxiliarNewDTO value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();				
		Auxiliar aux = auxiliarDados.findByEmail(value.getEmail());
		if (aux != null) {
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
