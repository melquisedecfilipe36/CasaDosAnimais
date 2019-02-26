package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.InternamentoServicos;
import com.projectoFinal.casaDosAnimais.dominio.Internamento;

@RestController
@RequestMapping(value="/internamento")
public class InternamentoResourse {
	
	@Autowired
	private InternamentoServicos internamentoServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Internamento> find(@PathVariable Integer id) {
		
		Internamento obj = internamentoServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
