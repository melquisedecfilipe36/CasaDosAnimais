package com.projectoFinal.casaDosAnimais.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectoFinal.casaDosAnimais.Servicos.EspecieServicos;
import com.projectoFinal.casaDosAnimais.dominio.Especie;

@RestController
@RequestMapping(value="/especie")
public class EspecieResourse {
	
	@Autowired
	private EspecieServicos especieServ;
	
	@RequestMapping (value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Especie> find(@PathVariable Integer id) {
		
		Especie obj = especieServ.procurar(id);		
		return ResponseEntity.ok().body(obj);
	}

}
