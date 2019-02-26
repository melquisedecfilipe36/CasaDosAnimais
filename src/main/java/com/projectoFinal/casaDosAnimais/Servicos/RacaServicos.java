package com.projectoFinal.casaDosAnimais.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectoFinal.casaDosAnimais.DAO.RacaDAO;
import com.projectoFinal.casaDosAnimais.Servicos.Expetion.ObjectNotFoundException;
import com.projectoFinal.casaDosAnimais.dominio.Raca;

@Service
public class RacaServicos {
	
	 
	
	@Autowired
	private RacaDAO racaDados;
	
	public Raca procurar(Integer id) {
		
		Optional<Raca> obj = racaDados.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Raca.class.getName()));
	
	}
	
	public Raca inserir(Raca obj) {
		
		obj.setId(null);
		
		return racaDados.save(obj);
	}

}
