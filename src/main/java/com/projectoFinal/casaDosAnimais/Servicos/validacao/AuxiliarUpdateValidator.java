package com.projectoFinal.casaDosAnimais.Servicos.validacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.projectoFinal.casaDosAnimais.DAO.AuxiliarDAO;
import com.projectoFinal.casaDosAnimais.DTO.AuxiliarDTO;
import com.projectoFinal.casaDosAnimais.dominio.Auxiliar;
import com.projectoFinal.casaDosAnimais.resources.execoes.FieldMessage;

public class AuxiliarUpdateValidator implements ConstraintValidator<AuxiliarUpdate, AuxiliarDTO>{

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private AuxiliarDAO auxiliarDados;
	
	
	@Override
	public void initialize(AuxiliarUpdate ann) {
	}

	
	
	@Override
	public boolean isValid(AuxiliarDTO value, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		Auxiliar aux = auxiliarDados.findByEmail(value.getEmail());
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
