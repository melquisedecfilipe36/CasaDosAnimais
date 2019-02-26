package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.LaboratorioServicos;
import com.projectoFinal.casaDosAnimais.dominio.Laboratorio;

@RestController
@RequestMapping(value="/laboratorio")
public class LaboratorioResourse {
	
	@Autowired
	private LaboratorioServicos laboratorioServico;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Laboratorio> find(@PathVariable Integer id) {
		
		Laboratorio obj = laboratorioServico.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
