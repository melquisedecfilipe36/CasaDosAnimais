package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.VacinaServicos;
import com.projectoFinal.casaDosAnimais.dominio.Vacina;

@RestController
@RequestMapping(value="/vacina")
public class VacinaResourse {
	
	@Autowired
	private VacinaServicos vacinaServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Vacina> find(@PathVariable Integer id) {
		
		Vacina obj = vacinaServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
