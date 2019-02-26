package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.CirurgiaServicos;
import com.projectoFinal.casaDosAnimais.dominio.Cirurgia;

@RestController
@RequestMapping(value="/cirurgia")
public class CirurgiaResourse {
	
	@Autowired
	private CirurgiaServicos cirurgiaServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cirurgia> find(@PathVariable Integer id) {
		
		Cirurgia obj = cirurgiaServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
