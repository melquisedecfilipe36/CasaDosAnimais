package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.RacaServicos;
import com.projectoFinal.casaDosAnimais.dominio.Raca;

@RestController
@RequestMapping(value="/raca")
public class RacaResourse {
	
	@Autowired
	private RacaServicos racaServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Raca> find(@PathVariable Integer id) {
		
		Raca obj = racaServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
