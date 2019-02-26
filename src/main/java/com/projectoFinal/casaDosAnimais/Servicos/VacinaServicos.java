package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.VacinaDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Vacina;


@Service
public class VacinaServicos {
	
	 
	
	@Autowired
	private VacinaDAO vacinaDados;
	
	public Vacina procurar(Integer id) {
		
		Optional<Vacina> obj = vacinaDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vacina.class.getName()));
	
	}
	
	public Vacina inserir(Vacina obj) {
		
		obj.setId(null);
		
		return vacinaDados.save(obj);
	}
}
