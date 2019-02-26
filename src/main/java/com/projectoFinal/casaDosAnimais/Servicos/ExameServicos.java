package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.ExameDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Exame;

@Service
public class ExameServicos {
		
	@Autowired
	private ExameDAO exameDados;
	
	public Exame procurar(Integer id) {
		
		Optional<Exame> obj = exameDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Exame.class.getName()));
	
	}
	
	public Exame inserir(Exame obj) {
		
		obj.setId(null);
		
		return exameDados.save(obj);
	}

}
