package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.ExameServicos;
import com.projectoFinal.casaDosAnimais.dominio.Exame;

@RestController
@RequestMapping(value="/exame")
public class ExameResourse {
	
	@Autowired
	private ExameServicos exameServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Exame> find(@PathVariable Integer id) {
		
		Exame obj = exameServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
