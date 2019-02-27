package com.projectoFinal.casaDosAnimais.Servicos.validacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;


import com.projectoFinal.casaDosAnimais.DAO.VeterinarioDAO;
import com.projectoFinal.casaDosAnimais.DTO.VeterinarioDTO;
import com.projectoFinal.casaDosAnimais.dominio.Veterinario;
import com.projectoFinal.casaDosAnimais.resources.execoes.FieldMessage;

public class VeterinarioUpdateValidator  implements ConstraintValidator<VeterinarioUpdate, VeterinarioDTO>{

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private VeterinarioDAO veterinarioDados;
	
	
	@Override
	public void initialize(VeterinarioUpdate ann) {
	}

	
	
	@Override
	public boolean isValid(VeterinarioDTO objDto, ConstraintValidatorContext context) {
		
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		Veterinario aux = veterinarioDados.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}

	
}
